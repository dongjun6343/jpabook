# JPA

JPA ( Java Persistence API ) 
 자바 진영의 ORM 기술 표준 (Object-Relational Mapping)
 - ORM 프레임워크는 객체와 관계형 데이터베이스를 매핑한다.
 - ORM 프레임워크는 객체와 테이블을 매핑해서 패러다임(틀,체계)의 불일치 문제를 개발자 대신 해결해준다.
 - ORM 프레임워크 : 하이버네이트 프레임워크가 가장 대중적이다.
 - 하이버네이트를 사용하기 위해 필요한 lib => Maven jar.
 
 - SQL에 의존적인 개발
	1. 회원 객체를 관리하는 MemberDAO(DAO : Data Access Object,데이터 접근 계층) 완성하고 기능 개발 완료.
	2. 갑자기 회원의 연락처도 함께 저장해달라는 요구사항이 들어옴.
	3. 회원 테이블에 TEL 컬럼 추가. 회원 객체에 TEL 필드 추가.
	4. 연락처 저장을 위한 INSERT SQL 수정.
	5. 회원 조회를 위한 SELECT SQL 수정.
	6. 연락처 수정을 위한 UPDATE SQL 수정.
 - JPA 문제 해결
	1. jpa.persist(member); // 저장.
	2. Member member = jpa.find(Member.class, memberId); // 조회.
	3. member.setName("이름변경"); // 수정.
	
	SQL에 의존적인 개발 ==> JPA 사용 => 개발자가 직접 SQL을 작성하는 것이 아니라 JPA가 제공하는 API를 사용하면 된다.
