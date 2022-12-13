package me.wydryszek.quiz;

public class Pytania {

	private String[] trescPytania;
	private String[][] opcje;
	private String[] odpowiedzi;
	
	public String [] getTrescPytania()
	{
		return trescPytania;
	}
	
	public String [][] getOpcje(){
		return opcje;
	}
	
	public String[] getOdpowiedzi()
	{
		return odpowiedzi;
	}
	
	public void setTrescPytania(String [] trescPytania) {
		this.trescPytania=trescPytania;
	}
	
	public void setOpcje(String [][] opcje) {
		this.opcje=opcje;
	}
	
	public void setOdpowiedzi(String [] odpowiedzi) {
		this.odpowiedzi=odpowiedzi;
	}
	
	
	public Pytania(String[] trescPytania, String[][] opcje, String[] odpowiedzi) {
		this.trescPytania=trescPytania;
		this.opcje=opcje;
		this.odpowiedzi=odpowiedzi;	
	}
	
	public String toString() {
		return trescPytania+" "+opcje+" "+odpowiedzi;
	}
	
	public Pytania() {}
}
