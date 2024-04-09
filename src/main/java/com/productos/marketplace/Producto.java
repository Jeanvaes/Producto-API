package com.productos.marketplace;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Producto {
    @Id
    private String id;
    private String nonmbre;
    private double precio;
    private int cantidad;
}
