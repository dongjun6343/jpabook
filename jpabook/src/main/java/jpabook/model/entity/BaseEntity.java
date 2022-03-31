package jpabook.model.entity;

import java.util.Date;

import javax.persistence.MappedSuperclass;

/**
 * MappedSuperclass
 * [문제] 모든 테이블에 등록일과 수정일 컬럼을 추가해야 한다.
 * [해결] 모든 엔터티에 등록일과 수정일을 추가하는 것보다 MappedSuperclass를 사용
 * 		부모 클래스를 만들어 상속받는 것이 효과적이다.
 * @author djpark
 *
 */

@MappedSuperclass
public class BaseEntity {

	private Date createDate; // 등록일
	private Date lastModifiedDate; // 수정일

	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}
	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

}
