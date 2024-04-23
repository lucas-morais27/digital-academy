package me.dio.academia.digital.repository;

import me.dio.academia.digital.entity.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MatriculaRepository extends JpaRepository<Matricula, Long> {

    @Query(value = "SELECT * FROM matriculas m " +
            "INNER JOIN alunos a ON m.aluno_id = a.id " +
            "WHERE a.bairro = :bairro", nativeQuery = true)
    List<Matricula> findByAlunoBairro(String bairro);

    //@Query("FROM Matricula m WHERE m.aluno.bairro = :bairro ")
    //List<Matricula> findByAlunoBairro(String bairro);

    //List<Matricula> findByAlunoBairro(String bairro);
}
