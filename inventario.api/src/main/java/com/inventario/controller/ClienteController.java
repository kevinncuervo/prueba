package com.inventario.controller;
import com.inventario.model.Cliente;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;



@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    private List<Cliente> clientes = new ArrayList<>();
    private long contadorId = 1;

   
    public ClienteController() {
        Cliente c1 = new Cliente();
        c1.setId(contadorId++);
        c1.setNombre("Juan Perez");
        c1.setIdentificacion("123456789");
        c1.setCorreo("juan.perez@email.com");
        c1.setCelular("3001234567");

        Cliente c2 = new Cliente();
        c2.setId(contadorId++);
        c2.setNombre("Maria Gomez");
        c2.setIdentificacion("987654321");
        c2.setCorreo("maria.gomez@email.com");
        c2.setCelular("3019876543");

        clientes.add(c1);
        clientes.add(c2);
    }
//GET localhost:8283/api/clientes/Mostrar
    @GetMapping("/Mostrar")
    public List<Cliente> getTodos() {
        return clientes;
    }
//POST localhost:8283/api/clientes/Crear
    @PostMapping("/Crear")
    public Cliente crearCliente(@RequestBody Cliente nuevo) {
        nuevo.setId(contadorId++);
        clientes.add(nuevo);
        return nuevo;
    }
    
//PUT localhost:8283/api/clientes/Actualizar/id
    @PutMapping("/Actualizar/{id}")
    public Cliente actualizarCliente(@PathVariable long id, @RequestBody Cliente clienteActualizado) {
        for (Cliente cliente : clientes) {
            if (cliente.getId() == id) {
                cliente.setNombre(clienteActualizado.getNombre());
                cliente.setIdentificacion(clienteActualizado.getIdentificacion());
                cliente.setCorreo(clienteActualizado.getCorreo());
                cliente.setCelular(clienteActualizado.getCelular());
                return cliente;
            }
        }
        return null;
    }
//DELETE  localhost:8283/api/clientes/Eliminar/id
    @DeleteMapping("/Eliminar/{id}")
    public String eliminarCliente(@PathVariable long id) {
        for (Cliente cliente : clientes) {
            if (cliente.getId() == id) {
                clientes.remove(cliente);
                return "Cliente eliminado con éxito";
            }
        }
        return "Cliente no encontrado";
    }
}

