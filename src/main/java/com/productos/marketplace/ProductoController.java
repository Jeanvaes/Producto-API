package com.productos.marketplace;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
@RequestMapping("/api/producto")
@AllArgsConstructor
public class ProductoController {

    @Autowired
    private ProductoRepository productRepository;

    @GetMapping(path = "/todos")
    public List<Producto> getAllProducts() {
        return productRepository.findAll();
    }

    @PostMapping(path = "/agregar")
    public String addProduct(@RequestBody Producto product) {

        try {
            productRepository.save(product);
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

}

