import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GetSchool {
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            emf = Persistence.createEntityManagerFactory("read");
            em = emf.createEntityManager();

            School sch = em.getReference(School.class, 1L);
            System.out.println(sch.getName());
            System.out.println("en alle studenten van die school zijn:");
            List<Student> studentList = sch.getStudents();

            Map<School, List<Student>> groupedBySchool =
                    studentList.stream()
                            .collect(Collectors.groupingBy(Student::getSchool));
            groupedBySchool.forEach(
                    (school, studentsInSchool) -> {
                        System.out.printf("%n%s%n", school);
                        studentsInSchool.forEach(
                                student -> System.out.printf(" %s%n", student));
                    }
            );
        }
        finally {
            if(em!= null) {em.close();}
            if(emf!=null) {emf.close();}
        }
    }
}
