package jpabook.start;

import javax.persistence.*;

/**
 * 준영속 병합
 * @author djpark
 *
 */
public class ExamMergeMain {
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");

	public static void main(String[] args) {
		Member member = createMember("memberA","회원1");

		member.setUsername("회원명변경"); // 준영속 상태에서 변경
	}

	private static Member createMember(String id, String username) {
		// 영속성 컨텍스트 1 시작.
		EntityManager em1 = emf.createEntityManager();
		EntityTransaction tx1 = em1.getTransaction();
		tx1.begin();

		Member member = new Member();
		member.setId(id);
		member.setUsername(username);

		em1.persist(member);
		tx1.commit();

		em1.close(); // 영속성 컨텍스트1 종료,
					// member엔터티는 준영속 상태가 된다.

		// == 영속성 컨텍스트 1 종료 == //

		return member;
	}
}
