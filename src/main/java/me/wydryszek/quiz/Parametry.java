package me.wydryszek.quiz;

public class Parametry {

	private int punkty;
	private boolean czyKolor;
	
	public void setPunkty(int punkty) {
		this.punkty=punkty;
	}
	
	public int getPunkty() {
		return punkty;
	}
	
	public void addPunkty() {
		punkty++;
	}
	
	public void setCzyKolor(boolean kolor) {
		this.czyKolor=kolor;
	}
	
	public boolean getCzyKolor() {
		return czyKolor;
	}

	
	public Parametry() {
		punkty=0;
		czyKolor=false;
	};
	
}
