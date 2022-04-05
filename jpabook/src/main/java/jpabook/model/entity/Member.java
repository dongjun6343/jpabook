package jpabook.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Member extends BaseEntity{

	@Id @GeneratedValue
	@Column(name = "MEMBER_ID")
	private Long id;

	private String name;

	private String city;
	private String street;
	private String zipcode;

	// 6. 값 타입 매핑 추가
	// 주소 정보에 필드나 로직이 추가되면 Address 값 타입만 변경하면 된다.
	@Embedded
	private Address address;

	// mappedBy : 반대쪽 매핑의 필드 이름을 값으로 준다.
	@OneToMany(mappedBy = "member")
	private List<Order> orders = new ArrayList<Order>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

}
