package com.productos.marketplace;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "Producto")
public class Producto {
    @Id
    private String id;
    private String nombre;
    private double precio;
    private int cantidad;
}
