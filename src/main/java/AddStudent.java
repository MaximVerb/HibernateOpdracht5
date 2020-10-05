import javax.persistence.EntityManager;
import javax.persistence.*;
import java.util.List;

public class AddStudent {
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        try {
            emf = Persistence.createEntityManagerFactory("read");
            em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            School sch = em.find(School.class,1L);
            List<Student> students = sch.getStudents();
            students.add(new Student("Kamala",sch));
            sch.setStudents(students);
            em.persist(sch);
            tx.commit();
        } finally {
            if(em!=null) {
                em.close();
            }
            if(emf!=null) {
                emf.close();
            }
        }
    }
}
