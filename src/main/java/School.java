import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @OneToMany (mappedBy = "school", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Student> students = new ArrayList<>();

    @OrderBy("name ASC")
    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public String getName() { return name; }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() { return id; }

    public void addStudent(Student student) {
        students.add(student);
        student.setSchool(this);
    }

    public void removeStudent(Student student) {
        students.remove(student);
        student.setSchool(null);
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
