package com.sammas.file;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class Trader {
	//@ManyToOne
    //@PrimaryKeyJoinColumn
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "hisse")
	private String hisse;

	@Column(name = "adet")
	private int adet;

	@Column(name = "tutar")
	private double tutar;


	@Column(name = "maliyet")
	private double maliyet;

	public Trader( ) {
	 
	}
	public Trader(String hisse, int adet, double tutar) {
		super();
		this.hisse = hisse;
		this.adet = adet;
		this.tutar = tutar;
	}

	public double getMaliyet() {
		return maliyet;
	}

	public void setMaliyet(double maliyet) {
		this.maliyet = maliyet;
	}

	public Long getId() {
		return id;
	}

	public String getHisse() {
		return hisse;
	}

	public void setHisse(String hisse) {
		this.hisse = hisse;
	}

	public int getAdet() {
		return adet;
	}

	public void setAdet(int adet) {
		this.adet = adet;
	}

	public double getTutar() {
		return tutar;
	}

	public void setTutar(double tutar) {
		this.tutar = tutar;
	}



	public void setId(Long id) {
		this.id = id;
	}


}