package jpabook.model.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity

// 자식 테이블은 DiscriminatorValue 어노테이션 사용
// 구분 컬럼(DTYPE)에 입력될 값을 정한다.
@DiscriminatorValue("A")
public class Album extends Item{

	private String artist;
	private String etc;

	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public String getEtc() {
		return etc;
	}
	public void setEtc(String etc) {
		this.etc = etc;
	}

}
