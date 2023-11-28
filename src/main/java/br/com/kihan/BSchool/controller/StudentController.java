package br.com.kihan.BSchool.controller;

import br.com.kihan.BSchool.service.StudentService;
import br.com.kihan.BSchool.dto.StudentDTO;
import br.com.kihan.BSchool.entity.Address;
import br.com.kihan.BSchool.entity.Student;
import br.com.kihan.BSchool.httpClient.CepHttpClient;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    StudentService studentService;
    @Autowired
    CepHttpClient cepHttpClient;

    @GetMapping
    public List<Student> getAll(){
        return studentService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getById(@PathVariable String id){
        Optional<Student> student = studentService.findById(id);
        if(student.isEmpty()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok().body(student.get());
    }

    @PostMapping
    public ResponseEntity<Student> insert(@RequestBody @Valid StudentDTO studentDTO){
        Student student = new Student(studentDTO);

        Address address = cepHttpClient.getAddressByCep(studentDTO.getCep());
        student.setAddress(address);

        studentService.insert(student);
        return ResponseEntity.created(null).body(student);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> update(@RequestBody Student newStudent, @PathVariable String id){
        Optional<Student> student = studentService.findById(id);
        if(student.isEmpty()) return ResponseEntity.notFound().build();
        studentService.update(id, newStudent);
        return ResponseEntity.ok().body(newStudent);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Student> updateCpf(@RequestParam("cpf") String cpf, @PathVariable String id){
        Optional<Student> student = studentService.findById(id);
        if(student.isEmpty()) return ResponseEntity.notFound().build();
        Student newStudent = student.get();
        newStudent.setCpf(cpf);
        studentService.update(id, newStudent);
        return ResponseEntity.ok().body(newStudent);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Student> delete(@PathVariable String id){
        Optional<Student> student = studentService.findById(id);
        if(student.isEmpty()) return ResponseEntity.notFound().build();
        studentService.remove(id);
        return ResponseEntity.ok().body(null);
    }
}
