package com.metaphorce.assesment2.assesment2.service;
import com.metaphorce.assesment2.assesment2.model.Tarea;
import com.metaphorce.assesment2.assesment2.repository.Repositorio;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public class TaskService {
    private final Repositorio repositorio;
    public TaskService(Repositorio repositorio) {
        this.repositorio = repositorio;
    }
    public Tarea create(Tarea tarea) {
        return repositorio.save(tarea);
    }
    public List<Tarea> getAll() {
        return repositorio.findAll();
    }
    public Tarea update(Tarea tarea) throws Exception {
        Tarea existing = repositorio.findById(tarea.getId())
                .orElseThrow(Exception::new);
        existing.setTitulo(tarea.getTitulo());
        existing.setCompletado(tarea.isCompletado());
        return repositorio.save(existing);
    }
    public void delete(Integer id) throws Exception {
        if (!repositorio.existsById(id)) {
            throw new Exception();
        }
        repositorio.deleteById(id);
    }
    public List<Tarea> getTareasIncompletas() {
        //return repositorio.findByCompletedFalse();
        return null;
    }
    public Tarea getById(Integer id) throws Exception {
        return repositorio.findById(id)
                .orElseThrow(Exception::new);
    }
}
