import lejos.nxt.Button;
import lejos.nxt.LCD;
import lejos.nxt.Sound;

/**
 * Robotin käyttöliittymä
 * 
 * Käytetään valosensorin arvojen kalibrointiin lähinnä.
 * @author jani
 *
 */
public class Kayttoliittyma {
	private Robotti robotti;
	
	public Kayttoliittyma(Robotti robotti) {
		this.robotti = robotti;
	}
	
	public void tervetuloIlmoitus() {
		System.out.println("Viivanseuraaja!");
		System.out.println();
	}
	
	public void pyydaAlintaArvoa() {
		System.out.println("Anna matalin");
		
		Button.waitForAnyPress();
		Sound.beep();
		robotti.kalibroiAlinArvo();
	}
	
	public void pyydaKorkeintaArvoa() {
		System.out.println("Anna korkein");
		Button.waitForAnyPress();
		Sound.beep();
		robotti.kalibroiKorkeinArvo();
	}
	
	public void kaynnista() {
		tervetuloIlmoitus();
		
		pyydaKorkeintaArvoa();
		pyydaAlintaArvoa();
		
		RobotinSammuttaja rs = new RobotinSammuttaja();
		
		Button.ESCAPE.addButtonListener(rs);
		
		LCD.clear();
		System.out.println("Aloitetaan reitin suorittaminen.");
		
		while (true) {
			robotti.kaynnista();
			robotti.kaannaRobottiYmpari();
		}
		
	}
}
