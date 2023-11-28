package br.com.kihan.BSchool.service;

import br.com.kihan.BSchool.entity.Student;
import br.com.kihan.BSchool.repository.StudentRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public List<Student> getAll(){
//        return studentRepository.findByName("Luffy");
        return studentRepository.findAll();
    }

    public Student insert(@RequestBody Student student){
        studentRepository.insert(student);
        return student;
    }

    public Student update(String id, Student newStudent){
        Optional<Student> student = findById(id);
        if(student.isPresent()){
            Student attStudent = student.get();
            attStudent.setCpf(newStudent.getCpf());
            attStudent.setName(newStudent.getName());
            attStudent.setLastName(newStudent.getLastName());
//            BeanUtils.copyProperties(newStudent, student.get());
            studentRepository.save(student.get());
            return student.get();
        }
        return null;
    }

    public void remove(String id){
        Optional<Student> student = findById(id);
        student.ifPresent(value -> studentRepository.delete(value));
//        if(student.isPresent()) studentRepository.delete(student.get());

    }

    public Optional<Student> findById(String id){
        return studentRepository.findById(id);
    }
}
