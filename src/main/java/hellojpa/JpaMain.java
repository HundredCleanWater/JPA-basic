package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();// JPA는 transaction이 있어야 실행이 됨
        tx.begin();

        try {
            //비영속
            Member member = new Member();
            member.setId(100L);
            member.setName("HIHI");

            //영속
            System.out.println("====BEFORE====");
            em.persist(member);
            System.out.println("====AFTER====");
            //---> persist순간 db에 저장되지 않음
            tx.commit();
            //--->commit 순간 db에 저장
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();

        //code
        em.close();

        emf.close();

    }
}
