import lejos.nxt.Button;
import lejos.nxt.LightSensor;
import lejos.nxt.Sound;
import lejos.robotics.navigation.DifferentialPilot;

/**
 * 
 * @author Jani Luukko <jani.luukko@cs.helsinki.fi>
 *
 */
public class Robotti {

	private DifferentialPilot diffP;
	private LightSensor lightS;
	private Tilasto tilasto;
	
	private boolean staph;
	private int asteet;
	private int aste;
	
	public Robotti(DifferentialPilot diffP, LightSensor lightS) {
		this.diffP = diffP;
		this.lightS = lightS;
		this.tilasto = new Tilasto();
		
		diffP.setTravelSpeed(diffP.getTravelSpeed()/2);
		diffP.setRotateSpeed(diffP.getRotateSpeed()/2);
		
		this.staph = false;
		this.asteet = 0;
		this.aste = 0;
	}
	
	/**
	 * Kalibroi robotille annetun valosensorin korkeimman arvon
	 * (valkotausta)
	 */
	public void kalibroiKorkeinArvo() {
		lightS.calibrateHigh();
	}
	
	/**
	 * Kalibroi robotille annetun valosensorin alimman arvon
	 * (viiva)
	 */
	public void kalibroiAlinArvo() {
		lightS.calibrateLow();
	}
	
	/**
	 * Käynnistää robotin. Robotti ryhtyy kulkemaan viivaa pitkin.
	 */
	public void kaynnista() {
		tilasto.setKierrokset(tilasto.getKierrokset()+1);
		staph = false;
		asteet = 0;
		aste = 10;
		while (staph != true) {
			
			liiku();
			
		}
	}

	private void liiku() {
		diffP.backward();
		
		while (!Button.ESCAPE.isDown() && lightS.getLightValue() > 60) {
			kaanny();
		}
		
		asteet = 0;
		staph = false;
	}

	private void kaanny() {
		diffP.rotate(aste);
		asteet += aste;
		
		tilasto.setKaannokset(tilasto.getKaannokset()+1);
		if (Math.abs(asteet) >= 80) {
			diffP.rotate(asteet*-1);
			if (staph == true) {
				Sound.twoBeeps();
				System.out.println("Reitti done");
				return;
				//diffP.rotate(180);
				//staph = false;
			} else {
				staph = true;
			}
			aste = aste*-1;
			asteet = 0;
		}
	}
	
	public void kaannaRobottiYmpari() {
		diffP.rotate(180);
	}
	
	
}
