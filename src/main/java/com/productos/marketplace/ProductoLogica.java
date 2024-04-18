package com.productos.marketplace;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductoLogica {

    private final ProductoRepository productoRepository;

    public String compra(String id, int cantidad){
        Producto producto = new Producto();

        producto = productoRepository.findById(id).orElse(null);

        productoRepository.deleteById(id);

        if (cantidad <= producto.getCantidad()){
            CompraLog compraLog = new CompraLog();

            producto.setCantidad(producto.getCantidad() - cantidad);
            productoRepository.insert(producto);

            compraLog.logVenta(producto.getNombre(), cantidad);

            return "Compra exitosa";
        }else {
            throw new IllegalArgumentException("No hay suficientes productos para comprar");
        }
    }

    private String actualizarProducto(String nombre, Consumer<Producto> actualizador) {
        Optional<Producto> productoOptional = productoRepository.findByNombre(nombre);

        if (productoOptional.isPresent()) {
            Producto producto = productoOptional.get();
            actualizador.accept(producto);
            productoRepository.save(producto);
            return "Producto actualizado exitosamente";
        } else {
            return "Producto no encontrado";
        }
    }

    public String actualizarPrecio(String nombre, double precio){
        return actualizarProducto(nombre, producto -> producto.setPrecio(precio));
    }

    public String actualizarCantidad(String nombre, int cantidad){
        return actualizarProducto(nombre, producto -> producto.setCantidad(cantidad));
    }

    public String actualizarNombre(String nombre, String nuevoNombre){
        return actualizarProducto(nombre, producto -> producto.setNombre(nuevoNombre));
    }
}
