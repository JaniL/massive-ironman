import lejos.nxt.LCD;


public class Tilasto {
	private int kaannokset;
	private int kierrokset;
	
	public Tilasto() {
		this.kaannokset = 0;
		this.kierrokset = 0;
	}
	
	public void tulostaNaytolle() {
		LCD.clear();
		System.out.println("Kierrokset:" + getKierrokset());
		System.out.println("Kaannokset:" + getKaannokset());
	}

	public int getKaannokset() {
		return kaannokset;
	}

	public void setKaannokset(int kaannokset) {
		this.kaannokset = kaannokset;
		
		tulostaNaytolle();
	}

	public int getKierrokset() {
		return kierrokset;
	}

	public void setKierrokset(int kierrokset) {
		this.kierrokset = kierrokset;
		
		tulostaNaytolle();
	}
}
