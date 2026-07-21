package com.example.student.controller;

import com.example.student.Service.StudentService;
import com.example.student.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/Student")
public class StudentController {
    @Autowired
    private StudentService ser;
    @PostMapping("/add")
    public String add(@RequestBody Student st){

        return ser.addstd(st);
    }
    @GetMapping("/getst")
    public List<Student> get(){
        return ser.getst();
    }
    @GetMapping("/getst/{id}")
    public Optional<Student> getbyid(@PathVariable String id){

        return ser.getstbyid(id);

    }
    @PutMapping("/update/{id}")
    public String update(@RequestBody Student st,@PathVariable String id){
        return ser.updatest(st,id);
    }
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable String id){
        return ser.deletest(id);
    }
}