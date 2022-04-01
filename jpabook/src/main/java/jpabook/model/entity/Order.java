package jpabook.model.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 5. 연관관계 정의 (2022.04.01)
 * 글로벌 패치 전략을 즉시 로딩으로 설정하면 사용하지 않는 엔터티도 함께 조회되므로
 * 지연 로딩으로 설정( @OneToMany , @ManyToMany 는 기본이 지연 로딩.)
 * @OneToOne, @ManyToOne은 fetch 속성을 지연 로딩으로 설정.
 *
 * 엔터티를 영속 상태로 만들어서 디비에 저장할 때 연관된 엔터티도 모두 영속 상태여야 한다.
 * ==> 영속성 전이 사용(Cascade)
 * ==> Order -> Delivery 관계인 delivery 필드에 영속성 전이.
 *	   Order -> OrderItem 관계인 orderItems 필드에 영속성 전이.
 * @author djpark
 *
 */

@Entity
@Table(name = "ORDERS")
public class Order extends BaseEntity{

	@Id @GeneratedValue
	@Column(name = "ORDER_ID")
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MEMBER_ID")
	private Member member; // 주문회원

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "DELIVERY_ID")
	private Delivery delivery; // 배송정보

	// mappedBy : 반대쪽 매핑의 필드 이름을 값으로 준다.
	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
	private List<OrderItem> orderItems = new ArrayList<OrderItem>();

	@Temporal(TemporalType.TIMESTAMP)
	private Date orderDate; // 주문시간

	@Enumerated(EnumType.STRING)
	private OrderStatus status; // 주문상태

	//==연관관계 메소드==//
	public void setMember(Member member) {
		// 기존 관계 제거
		if (this.member != null) {
			this.member.getOrders().remove(this);
		}
		this.member = member;
		this.member.getOrders().add(this);
	}

	public void addOrderItem(OrderItem orderItem) {
		orderItems.add(orderItem);
		orderItem.setOrder(this);
	}

	public void setDelivery(Delivery delivery) {
		this.delivery = delivery;
		delivery.setOrder(this);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Member getMember() {
		return member;
	}

	public enum OrderStatus {
		ORDER, CANCEL
	}
}