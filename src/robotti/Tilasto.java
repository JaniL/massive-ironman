package robotti;
import lejos.nxt.LCD;

/**
 * Tilastoi robotin tekemiä käännöksiä ja reitillä tehtyjä kierroksia.
 * @author Jani Luukko <jani.luukko@cs.helsinki.fi>
 *
 */
public class Tilasto {
	private int kaannokset;
	private int kierrokset;
	
	/**
	 * Tilaston konstruktori.
	 * Kierrokset ja käännökset alustetaan nollaksi.
	 */
	public Tilasto() {
		this.kaannokset = 0;
		this.kierrokset = 0;
	}
	
	/**
	 * Tulostaa tilastot NXT brickin näytölle.
	 */
	public void tulostaNaytolle() {
		LCD.clear();
		System.out.println("Kierrokset: " + getKierrokset());
		System.out.println("Kaannokset: " + getKaannokset());
	}

	/**
	 * Palauttaa tilastoidut käännökset
	 * @return Palauttaa robotin tekemien käännöksien lukumäärän
	 */
	public int getKaannokset() {
		return kaannokset;
	}

	/**
	 * Asettaa käännöksien lukumäärän.
	 * Tulostetaan autom. näytölle.
	 * @param kaannokset Käännöksien asetettava lukumäärä
	 */
	public void setKaannokset(int kaannokset) {
		this.kaannokset = kaannokset;
		
		tulostaNaytolle();
	}

	/**
	 * Palauttaa tilastoidut kierrokset
	 * @return Palauttaa robotin tekemien kierroksien lukumäärän
	 */
	public int getKierrokset() {
		return kierrokset;
	}

	/**
	 * Asettaa kierroksien lukumäärän.
	 * Tulostetaan autom. näytölle.
	 * @param kierrokset Kierroksien asetettava lukumäärä
	 */
	public void setKierrokset(int kierrokset) {
		this.kierrokset = kierrokset;
		
		tulostaNaytolle();
	}
}
