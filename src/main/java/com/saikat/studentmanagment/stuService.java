package com.saikat.studentmanagment;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.sql.init.SqlR2dbcScriptDatabaseInitializer;
import org.springframework.stereotype.Service;

@Service
public class stuService implements service{

    @Autowired
    private repository studRepository;

    @Override
    public String createStudent(Student stud){
        entity studEntity = new entity();
        BeanUtils.copyProperties(stud, studEntity);
        studRepository.save(studEntity);
        return "Added successfully !";
    }

    @Override
    public List<Student> readStudent(){
        List<entity> studs = studRepository.findAll();
        List<Student> students = new ArrayList<>();

        for (entity stud : studs){
            Student std = new Student();
            BeanUtils.copyProperties(stud, std);
            students.add(std);
        }

        return students;
    }

    @Override
    public Student readStudentByID(Long id){
        entity stud = studRepository.findById(id).get();
        Student std = new Student();

        BeanUtils.copyProperties(stud, std);
        return std;
    }

    @Override
    public String deleteStudent(Long id){
        entity stud = studRepository.findById(id).get();
        studRepository.delete(stud);

        return "Deleted successfully !";
    }

    @Override
    public String updateStudent(Long id, Student std){
        entity stud = studRepository.findById(id).get();

        stud.setName(std.getName());
        stud.setDept(std.getDept());
        stud.setMarks(std.getMarks());

        studRepository.save(stud);

        return "Updated successfully !";
    }
}
