package com.saikat.studentmanagment;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;



@RestController
public class controller {

    // List<Student> students = new ArrayList<>();
    // service studService = new stuService();

    @Autowired
    service studService;
    
    @GetMapping("student")
    public List<Student> getData() {
        return studService.readStudent();
    }

    @GetMapping("student/{id}")
    public Student getDataByID(@PathVariable Long id) {
        return studService.readStudentByID(id);
    }
    

    @PostMapping("student")
    public String sendData(@RequestBody Student stud){
        // students.add(stud);
        // return "Added successfully !";
        return studService.createStudent(stud);
    }

    @DeleteMapping("student/{id}")
    public String deleteData(@PathVariable Long id){
        return studService.deleteStudent(id);
    }

    @PutMapping("student/{id}")
    public String updateData(@PathVariable Long id, @RequestBody Student stud){
        return studService.updateStudent(id, stud);
    }
    
    

}
