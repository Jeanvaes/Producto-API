package com.productos.marketplace;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CompraLog {

    private static final String FILE_PATH = "ventas.txt";

    public void logVenta(String producto, int cantidad) {
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = dateTime.format(formatter);
        String ventaInfo = String.format("Venta realizada - Producto : %s, Cantidad: %d, Fecha y hora: %s\n", producto, cantidad, formattedDateTime);

        try {
            FileWriter writer = new FileWriter(FILE_PATH, true); // El segundo parámetro true indica que se añadirán los datos al final del archivo
            writer.write(ventaInfo);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
            // Manejo de errores
        }
    }
}
