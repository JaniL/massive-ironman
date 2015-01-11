import robotti.Kayttoliittyma;
import robotti.Robotti;
import util.RobotinSammuttaja;
import lejos.nxt.Button;
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
		
		RobotinSammuttaja rs = new RobotinSammuttaja();
		
		Button.ESCAPE.addButtonListener(rs);
		
		Kayttoliittyma kayttoliittyma = new Kayttoliittyma(robotti);
		
		kayttoliittyma.kaynnista();
	}

}
