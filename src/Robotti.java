import lejos.nxt.Button;
import lejos.nxt.LightSensor;
import lejos.nxt.Motor;
import lejos.nxt.NXTRegulatedMotor;
import lejos.nxt.Sound;
import lejos.robotics.navigation.DifferentialPilot;

/**
 * 
 * @author Jani Luukko <jani.luukko@cs.helsinki.fi>
 *
 */
public class Robotti {

	// private DifferentialPilot diffP;
	private NXTRegulatedMotor vasen;
	private NXTRegulatedMotor oikea;
	private LightSensor lightS;
	private Tilasto tilasto;
	
	public Robotti(NXTRegulatedMotor vasen, NXTRegulatedMotor oikea, LightSensor lightS) {
		// this.diffP = diffP;
		this.vasen = vasen;
		this.oikea = oikea;
		this.lightS = lightS;
		this.tilasto = new Tilasto();
		
		//diffP.setTravelSpeed(diffP.getTravelSpeed()*0.25);
		// diffP.setRotateSpeed(diffP.getRotateSpeed()*0.25);
		
		//vasen.setAcceleration(vasen.getAcceleration()/2/2);
		//oikea.setAcceleration(oikea.getAcceleration()/2/2);
		
		//vasen.setSpeed(vasen.getSpeed()/2/2);
		//oikea.setSpeed(oikea.getSpeed()/2/2);
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
		boolean suunta = false;
		boolean pois = false;
		while (true) {
			NXTRegulatedMotor moottori;
			
			if (suunta) {
				moottori = vasen;
			} else {
				moottori = oikea;
			}
			
			moottori.backward();
			int bleh = 0;
			while (moottori.isMoving()) {
				bleh++;
				System.out.println(bleh);
				if (pois == true && lightS.getLightValue() < 50) {
					// moottori.stop();
					pois = false;
					
					moottori.stop(true);
					
					//suunta = !suunta;
					bleh = 0;
					
					break;
				}
				
				if (pois == false && lightS.getLightValue() > 95) {
					moottori.stop(true);
					suunta = !suunta;
					bleh = 0;
					
					if (suunta) {
						moottori = vasen;
					} else {
						moottori = oikea;
					}
					
					pois = true;
					
					
					
					break;
				}
			}
		}
		/* boolean staph = false;
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
			
		} */
	}
	
	public void kaannaRobottiYmpari() {
		// diffP.rotate(180);
	}
	
	
}
