package br.com.kihan.BSchool.entity;

import br.com.kihan.BSchool.dto.StudentDTO;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "students")
public class Student {

    @Id
    private String id;

    @NotNull
    @Min(value = 1, message = "A matrícula deve ter um valor maior que 1!")
    private int registration;
    @NotEmpty
    private String name;
    private String lastName;
    private String cpf;
    private Address address;

    public Student(StudentDTO studentDTO) {
        setName(studentDTO.getName());
        setCpf(studentDTO.getCpf());
        setLastName(studentDTO.getLastName());
        setRegistration(studentDTO.getRegistration());
    }
}