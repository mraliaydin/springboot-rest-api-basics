package com.aliaydin.springboot.controller;

import com.aliaydin.springboot.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    @GetMapping("student")
    public ResponseEntity<Student> getStudent(){
        Student student = new Student(1,"Ali","Veli");

        //return new ResponseEntity<>(student, HttpStatus.OK);
        //return ResponseEntity.ok(student);

        return ResponseEntity.ok().header("custom-header", "ali")
                .body(student);
    }

    @GetMapping("students")
    public List<Student> getAllStudent(){
        Student student1 = new Student(1, "Ali","Veli");
        Student student2 = new Student(2, "Ahmet","Mahmut");

        List<Student> list = new ArrayList<>();

        list.add(student1);
        list.add(student2);
        list.add(new Student(3, "Zeynep","Naz"));

        return list;
    }

    @GetMapping("student/{id}/{name}/{lastName}")
    public Student studentPathVariable(@PathVariable int id, @PathVariable String name, @PathVariable("lastName") String surname){
        return new Student(id, name,surname);
    }


    // Request Param
    @GetMapping("students/query")
    public Student studentRequestVariable(@RequestParam int id,
                                          @RequestParam String firstName,
                                          @RequestParam String lastName){
        return new Student(id,"Ali","Veli");
    }

    //Post request
    @PostMapping("student/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudent(@RequestBody Student student){
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());

        return student;
    }

    // Put request
    @PutMapping("/student/{id}/update")
    public Student updateStudent(@RequestBody Student student, @PathVariable("id") int studentId){
        return student;
    }

    @DeleteMapping("/students/{id}/delete")
    public String deleteStudent(@PathVariable("id") int studentId){


        return "Student with " + studentId + " deleted successfully..!";
    }
}
