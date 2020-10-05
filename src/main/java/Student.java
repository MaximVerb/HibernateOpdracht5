import javax.persistence.*;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    public Student() {}

    public Student(String name) {
        this.name = name;
    }

    public Student(String name, School school) {
        this.name = name;
        this.school = school;
    }

    @ManyToOne
    private School school;

    public School getSchool() { return school; }

    public void setSchool(School school) {
        this.school = school;
    }

    public String getName() { return name; }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() { return id; }

    @Override
    public String toString() {
        return String.format("%s en de school is %s\n",getName(),getSchool().toString());
    }

    public Student getSt() {
        return this;
    }
}
