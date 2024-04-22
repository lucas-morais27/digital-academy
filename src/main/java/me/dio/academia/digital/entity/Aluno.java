package me.dio.academia.digital.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "alunos")
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Aluno {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  public String nome;

  @Column(unique = true)
  public String cpf;

  public String bairro;

  public LocalDate dataDeNascimento;

  @OneToMany(mappedBy = "aluno", fetch = FetchType.LAZY)
  @JsonIgnore
  public List<AvaliacaoFisica> avaliacoes = new ArrayList<>();

}
