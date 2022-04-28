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
            Member member = em.find(Member.class, 150L);
            member.setName("ZZZ");
            //---> 150이란 ID를 가진 멤버를 찾아서 이름을 ZZZ로 바꿈 하지만 em.persist를 해주지 않아도 저장됨
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
