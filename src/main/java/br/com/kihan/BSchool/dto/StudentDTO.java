package br.com.kihan.BSchool.dto;

import br.com.kihan.BSchool.entity.Address;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {

    @NotNull
    @Min(value = 1, message = "A matrícula deve ter um valor maior que 1!")
    private int registration;
    @NotEmpty
    private String name;
    private String lastName;
    private String cpf;
    private String cep;
}
