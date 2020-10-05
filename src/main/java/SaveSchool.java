import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Arrays;
import java.util.List;

public class SaveSchool {
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            emf = Persistence.createEntityManagerFactory("course");
            em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();

            tx.begin();
            School sch = new School();
            sch.setName("Junior high");
            Student[] stArr = {new Student("James", sch),
                    new Student("Bro", sch), new Student("Glory", sch)};
            List<Student> studentList = Arrays.asList(stArr);
            sch.setStudents(studentList);
            em.persist(sch);
            tx.commit();

        } finally {
            if (em != null) {
                em.close();
            }
            if (emf != null) {
                emf.close();
            }
        }
    }
}
