package com.productos.marketplace;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@AllArgsConstructor
public class ProductoController {

    @Autowired
    private ProductoRepository productRepository;

    @GetMapping
    public List<Producto> getAllProducts() {
        return productRepository.findAll();
    }

    @PostMapping
    public Producto addProduct(@RequestBody Producto product) {
        return productRepository.save(product);
    }

    @DeleteMapping
    public String deleteProduct(){
        try {

            return "";
        }catch (IllegalArgumentException e) {
            return "";
        }
    }

}

