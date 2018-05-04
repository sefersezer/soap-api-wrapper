package com.wrapper;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class Address {
	private String ULKE, IL, ILCE, LOKASYON, MAHALLE, CADDE, SOKAK,
			BINADAIRENO, BINABLOK, DAIRENO, POSTA_KOD, DEPTH;
	private double GEOCODE_DIKEY, GEOCODE_YATAY;
	private int SKOR;
	private double TAMAMLANMA_ORANI;

	public String getUlke() {
		return ULKE;
	}

	public void setUlke(String ulke) {
		this.ULKE = ulke;
	}

	public String getIl() {
		return IL;
	}

	public void setIl(String il) {
		this.IL = il;
	}

	public String getIlce() {
		return ILCE;
	}

	public void setIlce(String ilce) {
		this.ILCE = ilce;
	}

	public String getLokasyon() {
		return LOKASYON;
	}

	public void setLokasyon(String lokasyon) {
		this.LOKASYON = lokasyon;
	}

	public String getMahalle() {
		return MAHALLE;
	}

	public void setMahalle(String mahalle) {
		this.MAHALLE = mahalle;
	}

	public String getCadde() {
		return CADDE;
	}

	public void setCadde(String cadde) {
		this.CADDE = cadde;
	}

	public String getSokak() {
		return SOKAK;
	}

	public void setSokak(String sokak) {
		this.SOKAK = sokak;
	}

	public String getBinaDaireNo() {
		return BINADAIRENO;
	}

	public void setBinaDaireNo(String binaDaireNo) {
		this.BINADAIRENO = binaDaireNo;
	}

	public String getBinablok() {
		return BINABLOK;
	}

	public void setBinablok(String binablok) {
		this.BINABLOK = binablok;
	}

	public String getDaireNo() {
		return DAIRENO;
	}

	public void setDaireNo(String daireNo) {
		this.DAIRENO = daireNo;
	}

	public String getPostaKod() {
		return POSTA_KOD;
	}

	public void setPostaKod(String postaKod) {
		this.POSTA_KOD = postaKod;
	}

	public String getDepth() {
		return DEPTH;
	}

	public void setDepth(String depth) {
		this.DEPTH = depth;
	}

	public double getTamamlanmaOrani() {
		return TAMAMLANMA_ORANI;
	}

	public void setTamamlanmaOrani(double tamamlanmaOrani) {
		this.TAMAMLANMA_ORANI = tamamlanmaOrani;
	}

	public double getGeocodeDikey() {
		return GEOCODE_DIKEY;
	}

	public void setGeocodeDikey(double geocodeDikey) {
		this.GEOCODE_DIKEY = geocodeDikey;
	}

	public double getGeocodeYatay() {
		return GEOCODE_YATAY;
	}

	public void setGeocodeYatay(double geocodeYatay) {
		this.GEOCODE_YATAY = geocodeYatay;
	}

	public int getSkor() {
		return SKOR;
	}

	public void setSkor(int skor) {
		this.SKOR = skor;
	}
}
