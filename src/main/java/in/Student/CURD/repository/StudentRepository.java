package in.Student.CURD.repository;

import in.Student.CURD.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {


    List<Student> findByNameContainingIgnoreCase(String name);


    Optional<Student> findByEmail(String email);


    boolean existsByEmail(String email);


    List<Student> findByAgeBetween(int minAge, int maxAge);
    List<Student> findByName(String name);
}