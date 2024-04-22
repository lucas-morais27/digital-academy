package me.dio.academia.digital.entity.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AvaliacaoFisicaForm {

  @Positive(message = "O Id do aluno precisa ser positivo.")
  public Long alunoId;

  @NotNull(message = "Preencha o campo corretamente.")
  @Positive(message = "'${validatedValue}' precisa ser positivo.")
  public double peso;

  @NotNull(message = "Preencha o campo corretamente.")
  @Positive(message = "'${validatedValue}' precisa ser positivo.")
  @DecimalMin(value = "150", message = "'{$validatedValue}' precisa ser no mínimo {value}.")
  public double altura;
}
