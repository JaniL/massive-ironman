import robotti.Kayttoliittyma;
import robotti.Robotti;
import lejos.nxt.LightSensor;
import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.robotics.navigation.DifferentialPilot;

/**
 * 
 * @author Jani Luukko <jani.luukko@cs.helsinki.fi>
 *
 */
public class Main {

	public static void main(String[] args) {
		
		DifferentialPilot diffP = new DifferentialPilot(56, 120, Motor.B, Motor.C);
		LightSensor lightS = new LightSensor(SensorPort.S3);
		
		Robotti robotti = new Robotti(diffP, lightS);
		
		Kayttoliittyma kayttoliittyma = new Kayttoliittyma(robotti);
		
		kayttoliittyma.kaynnista();
	}

}
