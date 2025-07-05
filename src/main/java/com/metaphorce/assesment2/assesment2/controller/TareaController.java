package com.metaphorce.assesment2.assesment2.controller;
import com.metaphorce.assesment2.assesment2.model.Tarea;
import com.metaphorce.assesment2.assesment2.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/gestorDeTareas/tareas")
public class TareaController {
    @Autowired
    private TaskService service;
    // CREATE - POST
    @PostMapping
    public ResponseEntity<?> guardarTarea(@RequestBody Tarea tarea) {
        System.out.println(tarea);
        Tarea creado = service.create(tarea);
        return ResponseEntity.ok(creado);
    }
    // READ ONE - GET
    @GetMapping("/{id}")
    public ResponseEntity<Tarea> obtenerTareasPorId(@PathVariable Integer id) {
        return service.getAll()
                .stream()
                .filter(c -> c.getId() == (id))
                .findFirst()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    // UPDATE - PUT
    @PutMapping("/{id}")
    public ResponseEntity<Tarea> updateTarea(
            @RequestBody Tarea tarea) throws Exception {
        Tarea actualizado = service.update(tarea);
        return ResponseEntity.ok(actualizado);
    }
    // Pelicula
    // DELETE - DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarTarea(
            @PathVariable Integer id) throws Exception {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
