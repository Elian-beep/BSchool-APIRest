package br.com.kihan.BSchool.repository;

import br.com.kihan.BSchool.entity.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface StudentRepository extends MongoRepository<Student, String> {

    public Student findByRegistration(int registration);

    public List<Student> findByName(String name);

    public List<Student> findByNameNot(String name);

    public List<Student> findByNameAndLastName(String name, String lastName);

    public List<Student> findByLastNameOrCpf(String lastName, String cpf);

//    @Query("{ $or: [{lastName: ?0 }, {cpf: ?1}] }")
//    public List<Student> encontrarSobrenomeOuCpf(String lastName, String cpf);
}
