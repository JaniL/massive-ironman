package robotti;
import util.RobotinSammuttaja;
import lejos.nxt.Button;
import lejos.nxt.LCD;
import lejos.nxt.Sound;

/**
 * Robotin käyttöliittymä
 * 
 * Käytetään valosensorin arvojen kalibrointiin lähinnä.
 * @author Jani Luukko <jani.luukko@cs.helsinki.fi>
 *
 */
public class Kayttoliittyma {
	private Robotti robotti;
	
	public Kayttoliittyma(Robotti robotti) {
		this.robotti = robotti;
	}
	
	/**
	 * Käyttöliittymän käynnistyksessä tuleva
	 * tervetuloilmoitus
	 */
	private void tervetuloIlmoitus() {
		System.out.println("Viivanseuraaja!");
		System.out.println();
	}
	
	/**
	 * Pyytää käyttäjältä valosensorin matalinta arvoa
	 * (Yleensä arvo jonka valosensori saa mustasta teipistä.)
	 */
	private void pyydaAlintaArvoa() {
		System.out.println("Anna matalin");
		
		Button.waitForAnyPress();
		Sound.beep();
		robotti.kalibroiAlinArvo();
	}
	
	/**
	 * Pyytää käyttäjältä valosensorin korkeinta arvo
	 * (Yleensä arvo jonka valosensori saa valkoisesta paperista.)
	 */
	private void pyydaKorkeintaArvoa() {
		System.out.println("Anna korkein");
		Button.waitForAnyPress();
		Sound.beep();
		robotti.kalibroiKorkeinArvo();
	}
	
	/**
	 * Käynnistää käyttöliittymän.
	 * 
	 * Käyttöliittymä pyytää käyttäjältä valosensorin korkeimman ja matalimman arvon,
	 * jonka jälkeen se käynnistää itse robotin.
	 */
	public void kaynnista() {
		tervetuloIlmoitus();
		
		pyydaKorkeintaArvoa();
		pyydaAlintaArvoa();
			
		LCD.clear();
		System.out.println("Aloitetaan reitin suorittaminen.");
		
		while (true) {
			robotti.kaynnista();
		}
		
	}
}
