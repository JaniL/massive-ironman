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
	
	public Robotti(DifferentialPilot diffP, LightSensor lightS) {
		this.diffP = diffP;
		this.lightS = lightS;
		this.tilasto = new Tilasto();
		
		diffP.setTravelSpeed(diffP.getTravelSpeed()*0.25);
		diffP.setRotateSpeed(diffP.getRotateSpeed()*0.25);
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
		boolean staph = false;
		int asteet = 0;
		int aste = 10;
		while (staph != true) {
			
			diffP.backward();
			
			while (!Button.ESCAPE.isDown() && lightS.getLightValue() > 60) {
				diffP.rotate(aste);
				asteet += aste;
				
				tilasto.setKaannokset(tilasto.getKaannokset()+1);
				if (Math.abs(asteet) == 50) {
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
			
			asteet = 0;
			staph = false;
			
		}
	}
	
	public void kaannaRobottiYmpari() {
		diffP.rotate(180);
	}
	
	
}
