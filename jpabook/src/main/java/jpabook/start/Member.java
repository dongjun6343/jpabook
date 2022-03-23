package jpabook.start;

import javax.persistence.*;

@Entity
@Table(name="Member")
public class Member {

	// 식별자 필드
	@Id
	@Column(name = "ID")
	private String id;

	@Column(name = "NAME")
	private String username;

	// 매핑 정보가 없는 필드
	private Integer age;

}
