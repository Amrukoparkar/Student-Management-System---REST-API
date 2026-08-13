package in.Student.CURD.service;

import in.Student.CURD.model.Student;
import java.util.List;
import java.util.Optional;

public interface StudentService {

    Student createStudent(Student student);


    List<Student> getAllStudents();


    Optional<Student> getStudentById(Long id);


    Optional<Student> getStudentByEmail(String email);


    List<Student> searchStudentsByName(String name);


    List<Student> getStudentsByAgeRange(int minAge, int maxAge);


    Student updateStudent(Long id, Student studentDetails);


    void deleteStudent(Long id);


    void deleteAllStudents();


    long countStudents();
    List<Student> getStudentsByExactName(String name);
}