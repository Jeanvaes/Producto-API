package com.productos.marketplace;

import org.springframework.web.bind.annotation.*;
import com.productos.marketplace.ProductoLogica;

import java.util.List;

@RestController
@RequestMapping("/api/producto")
public class ProductoController {

    private final ProductoRepository productRepository;

    private final ProductoLogica productoLogica;
    private final ProductoRepository productoRepository;

    public ProductoController(ProductoRepository productRepository, ProductoLogica productoLogica, ProductoRepository productoRepository) {
        this.productRepository = productRepository;
        this.productoLogica = productoLogica;
        this.productoRepository = productoRepository;
    }

    @GetMapping(path = "/todos")
    public List<Producto> getAllProducts() {
        return productRepository.findAll();
    }

    @PostMapping(path = "/agregar")
    public String addProduct(@RequestBody Producto product) {

        try {
            productoRepository.save(product);
            return "Se guardo el producto";
        }catch (IllegalArgumentException e){
            return "No se guardo el producto";
        }

    }

    @DeleteMapping(path = "/eliminar/{id}")
    public String deleteProduct(@PathVariable String id){
        try {
            productRepository.deleteById(id);
            return "Se agrego el producto";
        }catch (IllegalArgumentException e) {
            return "No se eleminino el producto";
        }
    }

    @PutMapping(path = "/comprar")
    public String buyProduct(@RequestParam String id, @RequestParam int cantidad){
        try {
            productoLogica.compra(id, cantidad);
            return "Se compro el producto";
        }catch (IllegalArgumentException e) {
            return "No se compro el producto";
        }
    }

    @PutMapping(path = "/actualizar/precio")
    public String actualizarPrecio(@RequestParam String nombre, @RequestParam int precio) {

        try {
            productoLogica.actualizarPrecio(nombre, precio);
            return "Se actualizo el precio";
        }catch (IllegalArgumentException e){
            return "No se actualizo el precio";
        }

    }

    @PutMapping(path = "/actualizar/cantidad")
    public String actualizarCantidad(@RequestParam String nombre, @RequestParam int cantidad) {

        try {
            productoLogica.actualizarCantidad(nombre, cantidad);
            return "Se actualizo el cantidad";
        }catch (IllegalArgumentException e){
            return "No se actualizo la cantidad";
        }

    }

    @PutMapping(path = "/actualizar/nombre")
    public String actualizarNombre(@RequestParam String nombre, @RequestParam String nuevoNombre) {

        try {
            productoLogica.actualizarNombre(nombre, nuevoNombre);
            return "Se actualizo el nombre";
        }catch (IllegalArgumentException e){
            return "No se actualizo el nombre";
        }

    }

}

