package jpabook.model.entity;

public class Ex10 {
/*
	1. JPQL(Java Persistence Query Language)
	엔티티 객체 조회하는 객체지향 쿼리다.

	Ex) 회원 이름이 kim인 엔티티를 조회해라.

	쿼리 생성
	String jqpl = "select m from Member as m where m.username = 'kim'";
	List<Member> resultList = em.createQuery(jpql, Member.class).getResultList();
	m.username 은 컬럼명이 아니라 엔티티 객체의 필드명이다.

	JPQL도 SQL처럼 SELECT, UPDATE, DELETE문을 사용할 수 있다.
	(INSERT문은 EntityManager.persist() 메소드를 사용하면 되므로 없다.)

	작성한 JPQL을 실행하려면 쿼리 객체(TypeQuery, Query)를 만들어야 한다.
	반환타입이 명확 -> TypeQuery
	반환타입이 명확X -> Query

	파라미터 바인딩 방식 ( 이름 기준, 위치 기준 )
	이름 기준 파라미터 바인딩 방식을 사용하는 것이 더 명확하다.
	Ex)
	String usernameParam = "User1";

	TypedQuery<Member> query =
		em.creatQuery("Select m From Member m where m.username
		 	= :username", Member.class);

	query.setParameter("username", usernameParam);
	List<Member> resultList = query.getResultList();

	==> JPQL API는 대부분 메소드 체인 방식으로 설계 되어 있어서 다음과 같이 작성 가능.

	TypedQuery<Member> query =
		em.creatQuery("Select m From Member m where m.username
		 	= :username", Member.class)
		 	.setParameter("username", usernameParam)
			.getResultList();

	프로젝션.
	SELECT절에 조회할 대상을 지정하는 것을 프로젝션이라고 한다.
	[SELECT {프로젝션 대상} FROM]
	프로젝션 대상 : 엔티티, 임베디드 타입, 스칼라 티입(숫자,문자 등 기본데이터 타입을 말함)

	임베디드 타입은 조회의 시작점이 될 수 없다!! [page.360 참고]

	


============================================================================================
	2. QueryDSL

	Ex)
  	준비.
	JPAQuery query = new JPAQuery(em);
	QMember member = Qmember.member;

	쿼리, 결과 조회
	List<Member> members =
		query.from(member)
		.where(member.username.eq("kim"))
		.list(member);

*/
}
