package hu.unideb.web;

import hu.unideb.model.Student;
import hu.unideb.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.time.OffsetDateTime;
import java.util.List;

@RestController
public class StudentControllerImpl
        implements StudentController {

    @Autowired //interface-hez, megnezi hol van implementalva, es ugy peldanyositja
    private StudentRepository repository;
    //2. modszer (constructor-ral, Autowired nelkul):
    //private final StudentRepository;
    //
    //public StudentRepositoryImpl(StudentRepository sr){
    //  ...
    // }
    //tobb implementacional:
    //ciklikus fuggoseg A->B->C->A... nem tudja, melyiket peldanyositsa eloszor

    @Override
    public List<Student> findAll() {
        System.out.println("findAll()");
        return null;
    }

    @Override
    public Student findOne(String neptun) {
        System.out.println("findOne()");
        return new Student(
                neptun,
                "Teszt Elek",
                Student.Program.CS_BSC,
                OffsetDateTime.now(),
                OffsetDateTime.now()
        );
    }

    @Override
    public Student createOne(Student student) {
        System.out.println("createOne()");
        return student;
    }

    @Override
    public Student updateOne(Student updated) {
        return null;
    }

    @Override
    public void deleteOne(String neptun) {

    }
}
