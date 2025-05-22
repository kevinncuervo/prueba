package com.inventario;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class InventarioApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventarioApiApplication.class, args);
    }
// localhost:8283
    @GetMapping("/")
    public String home() {
        return "Bienvenido a la API de Inventario Drogueria";
    }
}
