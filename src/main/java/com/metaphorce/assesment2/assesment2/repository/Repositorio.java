package com.metaphorce.assesment2.assesment2.repository;
import com.metaphorce.assesment2.assesment2.model.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface Repositorio extends JpaRepository<Tarea, Integer> {
    List<Tarea> findByCompletadoFalse();
}
