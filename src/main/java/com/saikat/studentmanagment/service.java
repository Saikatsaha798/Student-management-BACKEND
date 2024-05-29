package com.saikat.studentmanagment;

import java.util.List;

public interface service {

    String createStudent(Student stud);
    List<Student> readStudent();
    Student readStudentByID(Long id);
    String deleteStudent(Long id);
    String updateStudent(Long id, Student stud);

}
