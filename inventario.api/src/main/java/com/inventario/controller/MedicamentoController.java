package com.inventario.controller;

import com.inventario.model.Medicamento;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/medicamentos")
public class MedicamentoController {

    private List<Medicamento> medicamentos = new ArrayList<>();
    private long contadorId = 1;

    public MedicamentoController() {
        Medicamento m1 = new Medicamento();
        m1.setId(contadorId++);
        m1.setNombre("Paracetamol");
        m1.setCategoria("Analgésico y antipirético");
        m1.setFechaDeVencimiento("2025-12-31");
        m1.setPrecio(1500);

        Medicamento m2 = new Medicamento();
        m2.setId(contadorId++);
        m2.setNombre("Ibuprofeno");
        m2.setCategoria("Antiinflamatorio no esteroideo");
        m2.setFechaDeVencimiento("2024-06-30");
        m2.setPrecio(20000);

        medicamentos.add(m1);
        medicamentos.add(m2);
    }
// localhost:8283/api/medicamentos/Mostrar
    @GetMapping("/Mostrar")
    public List<Medicamento> getTodos() {
        return medicamentos;
    }
// localhost:8283/api/medicamentos/Crear
    @PostMapping("/Crear")
    public Medicamento crearMedicamento(@RequestBody Medicamento nuevo) {
        nuevo.setId(contadorId++);
        medicamentos.add(nuevo);
        return nuevo;
    }
// localhost:8283/api/medicamentos/Actualizar/id
    @PutMapping("/Actualizar/{id}")
    public Medicamento actualizarMedicamento(@PathVariable long id, @RequestBody Medicamento medicamentoActualizado) {
        for (Medicamento medicamento : medicamentos) {
            if (medicamento.getId() == id) {
                medicamento.setNombre(medicamentoActualizado.getNombre());
                medicamento.setCategoria(medicamentoActualizado.getCategoria());
                medicamento.setFechaDeVencimiento(medicamentoActualizado.getFechaDeVencimiento());
                medicamento.setPrecio(medicamentoActualizado.getPrecio());
                return medicamento;
            }
        }
        return null;
    }
// localhost:8283/api/medicamentos/Eliminar/id
    @DeleteMapping("/Eliminar/{id}")
    public String eliminarMedicamento(@PathVariable long id) {
        for (Medicamento medicamento : medicamentos) {
            if (medicamento.getId() == id) {
                medicamentos.remove(medicamento);
                return "Medicamento eliminado con éxito";
            }
        }
        return "Medicamento no encontrado";
    }
}
