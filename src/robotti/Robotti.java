package robotti;
import lejos.nxt.Button;
import lejos.nxt.LightSensor;
import lejos.nxt.Sound;
import lejos.robotics.navigation.DifferentialPilot;

/**
 * Viivanseuraajarobotti.
 * 
 * Kulkee viivaa pitkin. Kääntyilee kun lipsuu valkoiselle paperille.
 * Kyllä te tiiätte tän.
 * @author Jani Luukko <jani.luukko@cs.helsinki.fi>
 *
 */
public class Robotti {

	/**
	 * Robotin liikkumiseen käytettävä
	 * DifferentialPilot-olio.
	 */
	private DifferentialPilot diffP;
	
	/**
	 * Viivan tunnistamiseen käytettävä
	 * valosensori.
	 */
	
	private LightSensor lightS;
	
	/**
	 * Käännöksien ja kierrosten kirjanpito.
	 */
	private Tilasto tilasto;
	
	/**
	 * Indikoi milloin pitää pysähtyä.
	 */
	private boolean pysahdy;
	
	/**
	 * Käännöksien astemäärien kokonaismäärä.
	 */
	private int kaydytAsteet;
	
	/**
	 * Rotatessa käytettävä astemäärä.
	 */
	private int astemaara;
	
	public Robotti(DifferentialPilot diffP, LightSensor lightS) {
		this.diffP = diffP;
		this.lightS = lightS;
		this.tilasto = new Tilasto();
		
		diffP.setTravelSpeed(diffP.getTravelSpeed()/2);
		diffP.setRotateSpeed(diffP.getRotateSpeed()/2);
		
		this.pysahdy = false;
		this.kaydytAsteet = 0;
		this.astemaara = 0;
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
	 * Käynnistää robotin.
	 */
	public void kaynnista() {
		tilasto.setKierrokset(tilasto.getKierrokset()+1);
		pysahdy = false;
		kaydytAsteet = 0;
		astemaara = 10;
		while (pysahdy != true) {
			
			liiku();
			
		}
	}

	/**
	 * Suorittaa robotille käskyn liikkua eteenpäin ja
	 * ja kääntyy kun valosensorin arvo viittaa paperille
	 * siirtymiseen.
	 */
	private void liiku() {
		diffP.backward();
		
		while (!Button.ESCAPE.isDown() && lightS.getLightValue() > 60) {
			kaanny();
		}
		
		kaydytAsteet = 0;
		pysahdy = false;
	}

	
	/**
	 * liiku()-metodissa käytettävä kääntymismetodi robotille.
	 * Kääntyy maksimissaan tietyn astemäärän ellei viivaa löydy.
	 * Jos viivaa ei löydy, robotti kääntyy alkuperäiseen kulmaansa
	 * ja kääntyy toiseen suuntaan.
	 * 
	 * Mikäli viivaa ei löydy toiselta puolelta, robotti kääntyy alkuperäiseen
	 * kulmaansa ja sitten kääntyy 180 astetta.
	 */
	private void kaanny() {
		diffP.rotate(astemaara);
		kaydytAsteet += astemaara;
		
		tilasto.setKaannokset(tilasto.getKaannokset()+1);
		if (Math.abs(kaydytAsteet) >= 80) {
			diffP.rotate(kaydytAsteet*-1);
			if (pysahdy == true) {
				Sound.twoBeeps();
				System.out.println("Reitti done");
				kaannaRobottiYmpari();
				tilasto.setKierrokset(tilasto.getKierrokset()+1);
				//return;
				//diffP.rotate(180);
				//staph = false;
			} else {
				pysahdy = true;
			}
			astemaara = astemaara*-1;
			kaydytAsteet = 0;
		}
	}
	
	/**
	 * Kääntää robotin 180 astetta.
	 * 
	 * Käytetään silloin kun reitti on käyty läpi,
	 * eikä robotin vasemmalta ja oikealta
	 * puolelta löydy viivaa.
	 */
	private void kaannaRobottiYmpari() {
		diffP.rotate(180);
	}
	
	
}
