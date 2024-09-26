package hu.unideb.web;

import hu.unideb.model.Student;
import org.springframework.web.bind.annotation.RestController;

import java.time.OffsetDateTime;
import java.util.List;

@RestController //automatikus peldanyositas
public class StudentControllerImpl implements StudentController{
    @Override
    public List<Student> findAll() {
        System.out.println("findAll()");
        return List.of();
    }

    @Override
    public Student findOne(String neptun) {
        return new Student(
                neptun,
                "Test Elek",
                Student.Program.CS_BSC,
                OffsetDateTime.now(),
                OffsetDateTime.now()
        );
    }

    @Override
    public Student createOne(Student student) {
        System.out.println("createOne()");
        return null;
    }

    @Override
    public Student updateOne(Student updated) {
        return null;
    }

    @Override
    public void deleteOne(String neptun) {

    }
}
