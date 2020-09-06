package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hello");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();

        try {
            Member member = new Member();
            member.setId(1L);
            member.setName("HelloA");
            entityManager.persist(member);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            entityManager.close();
        }


        entityManager = entityManagerFactory.createEntityManager();
        tx = entityManager.getTransaction();
        tx.begin();
        try {
            Member findMember = entityManager.find(Member.class, 1L);
            System.out.println(findMember.getId());
            System.out.println(findMember.getName());
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            entityManager.close();
        }

        entityManager = entityManagerFactory.createEntityManager();
        tx = entityManager.getTransaction();
        tx.begin();
        try {
            Member findMember = entityManager.find(Member.class, 1L);
            findMember.setName("HelloJPA");

            //객체를 대상으로하는 객체지향 쿼리
            List<Member> result = entityManager.createQuery("select m from Member as m", Member.class)
                    .setFirstResult(5)
                    .setMaxResults(8)
                    .getResultList();
            for (Member member : result) {
                System.out.println(member.getName());
            }

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            entityManager.close();
        }

        entityManagerFactory.close();
    }
}
