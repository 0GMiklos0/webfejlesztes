package hu.unideb.repository;

import hu.unideb.model.Student;
import lombok.NonNull;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;


@Repository
public class StudentRepositoryImpl implements StudentRepository{

    private static final Logger LOGGER = LoggerFactory.getLogger(
            StudentRepositoryImpl.class
    );

    public StudentRepositoryImpl() {
        students = new TreeMap<>();
        //hash ha a kulcs implementalja a hashCode()-ot
        //tree ha a Comparable-t implementalja
    }

    private final Map<String, Student> students;

    @Override
    public List<Student> findAll() {
        LOGGER.info("findAll()");
        return students.values().stream().toList();
    }

    @Override
    public Optional<Student> findOne(@NonNull String neptun) {
        return Optional.ofNullable(students.get(neptun));
        //ha van a kulccsal ertek visszaadja, ha nem talalja, akkor null-t ad vissza
    }

    @Override
    public Student createOne(@NonNull Student student) {
        if(students.containsKey(student.getNeptun())){
            throw new IllegalArgumentException("Student already exists");
        }

        final OffsetDateTime now = OffsetDateTime.now();
        student.setCreated(now);
        student.setUpdated(now);

        students.put(student.getNeptun(), student);

        return student;
    }

    @Override
    public Student updateOne(@NonNull Student student) {

        Student original = findOne(student.getNeptun())
                .orElseThrow(() -> new IllegalArgumentException("The student doesn't exist."));
        original.setName(student.getName());
        original.setProgram(student.getProgram());
        original.setUpdated(OffsetDateTime.now());

        return original;
    }

    @Override
    public void deleteOne(@NonNull String neptun) {

        findOne(neptun)
                .orElseThrow(() -> new IllegalArgumentException("The student doesn't exist."));
        students.remove(neptun);
    }
}
