package in.Student.CURD.controller;

import in.Student.CURD.model.Student;
import in.Student.CURD.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class StudentController {

    private final StudentService studentService;


    @PostMapping
    public ResponseEntity<Student> createStudent(@Valid @RequestBody Student student) {
        if (studentService.getStudentByEmail(student.getEmail()).isPresent()) {
            throw new RuntimeException("Student with email " + student.getEmail() + " already exists");
        }
        Student savedStudent = studentService.createStudent(student);
        return new ResponseEntity<>(savedStudent, HttpStatus.CREATED);
    }


    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = studentService.getAllStudents();
        if (students.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(students, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        Student student = studentService.getStudentById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
        return new ResponseEntity<>(student, HttpStatus.OK);
    }


    @GetMapping("/email/{email}")
    public ResponseEntity<Student> getStudentByEmail(@PathVariable String email) {
        Student student = studentService.getStudentByEmail(email)
                .orElseThrow(() -> new RuntimeException("Student not found with email: " + email));
        return new ResponseEntity<>(student, HttpStatus.OK);
    }


    @GetMapping("/search/name")
    public ResponseEntity<List<Student>> searchByName(@RequestParam String name) {
        List<Student> students = studentService.searchStudentsByName(name);
        if (students.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(students, HttpStatus.OK);
    }
    @GetMapping("/search/name-exact")
    public ResponseEntity<List<Student>> searchByNameExact(@RequestParam String name) {
        List<Student> students = studentService.getStudentsByExactName(name);
        if (students.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(students, HttpStatus.OK);
    }



    @GetMapping("/age-range")
    public ResponseEntity<List<Student>> getStudentsByAgeRange(
            @RequestParam int minAge, @RequestParam int maxAge) {
        List<Student> students = studentService.getStudentsByAgeRange(minAge, maxAge);
        if (students.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(students, HttpStatus.OK);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id,
                                                 @Valid @RequestBody Student studentDetails) {
        Student updatedStudent = studentService.updateStudent(id, studentDetails);
        return new ResponseEntity<>(updatedStudent, HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @DeleteMapping("/delete-all")
    public ResponseEntity<Map<String, String>> deleteAllStudents() {
        studentService.deleteAllStudents();
        Map<String, String> response = new HashMap<>();
        response.put("message", "All students deleted successfully");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @GetMapping("/count")
    public ResponseEntity<Map<String, Long>> countStudents() {
        long count = studentService.countStudents();
        Map<String, Long> response = new HashMap<>();
        response.put("totalStudents", count);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}