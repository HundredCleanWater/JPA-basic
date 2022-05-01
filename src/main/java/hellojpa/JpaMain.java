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
            Member member = em.find(Member.class, 1L);
            member.setName("ZZZ");

            em.clear();
            em.find(Member.class, 2L);
            System.out.println("===========");
            tx.commit();
            //--->commit 순간 db에 저장
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();


    }
}
