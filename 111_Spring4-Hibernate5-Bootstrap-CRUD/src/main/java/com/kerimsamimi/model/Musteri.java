package com.kerimsamimi.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Kerim Samimi
 * @since 17.03.2019
 */

@Entity
@Table(name="Musteri")
public class Musteri implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4859483482229534670L;

	/**
	 * 
	 */
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long musteriId;
	
	@Column
	private String musteriAdi;
	
	@Column
	private String musteriSoyadi;
	
	@Column
	private int musteriNo;
	
	public Musteri() {
		System.out.println("Musteri");
	}
	
	public Musteri(String musteriAdi, String musteriSoyadi, int musteriNo) {
		super();
		this.musteriAdi = musteriAdi;
		this.musteriSoyadi = musteriSoyadi;
		this.musteriNo = musteriNo;
	} 

	

	public long getMusteriId() {
		return musteriId;
	}

	public void setMusteriId(long musteriId) {
		this.musteriId = musteriId;
	}

	public String getMusteriAdi() {
		return musteriAdi;
	}

	public void setMusteriAdi(String musteriAdi) {
		this.musteriAdi = musteriAdi;
	}

	public String getMusteriSoyadi() {
		return musteriSoyadi;
	}

	public void setMusteriSoyadi(String musteriSoyadi) {
		this.musteriSoyadi = musteriSoyadi;
	}

	public int getMusteriNo() {
		return musteriNo;
	}

	public void setMusteriNo(int musteriNo) {
		this.musteriNo = musteriNo;
	}

	@Override
	public String toString() {
		return "Musteri [musteriId=" + musteriId + ", musteriAdi=" + musteriAdi + ", musteriSoyadi=" + musteriSoyadi
				+ ", musteriNo=" + musteriNo + "]";
	}
	
}
