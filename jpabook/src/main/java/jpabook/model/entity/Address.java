package jpabook.model.entity;

import javax.persistence.Embeddable;

/**
 * 6. 값 타입 매핑
 * 엔티티 타입 VS 값 타입
 *
 * 엔티티 타입
 * 	- 식별자(@id)가 있다.
 *  - 생명 주기가 있다.
 *		1. em.persist(entity)로 영속화한다.
 *		2. em.remove(entity)로 제거한다.
 *	- 공유할 수 있다.
 * 		1. 참조 값을 공유할 수 있다.(참조 공유)
 * 		2. 예를 들어 회원 엔티티가 있다면 다른 엔티티에서 얼마든지 회원 엔티티를 참조할 수 있다.
 *
 * 값 타입
 *  - 식별자가 없다.
 *  - 공유하지 않는 것이 안전하다. (불변)
 *
 * [정리]
 * 식별자가 필요하고 지속해서 값을 추적하고
 * 구분하고 변경해야 한다면 그것은 값 타입이 아닌 엔티티다.
 *
 * @author djpark
 *
 */

@Embeddable
public class Address {

	private String city;
	private String street;
	private String zipcode;

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((street == null) ? 0 : street.hashCode());
		result = prime * result + ((zipcode == null) ? 0 : zipcode.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (street == null) {
			if (other.street != null)
				return false;
		} else if (!street.equals(other.street))
			return false;
		if (zipcode == null) {
			if (other.zipcode != null)
				return false;
		} else if (!zipcode.equals(other.zipcode))
			return false;
		return true;
	}
}
