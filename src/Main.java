import lejos.nxt.LightSensor;
import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.robotics.navigation.DifferentialPilot;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DifferentialPilot diffP = new DifferentialPilot(56, 120, Motor.B, Motor.C);
		LightSensor lightS = new LightSensor(SensorPort.S3);
		
		// Robotti robotti = new Robotti(diffP, lightS);
		Robotti robotti = new Robotti(Motor.B,Motor.C,lightS);
		
		Kayttoliittyma kayttoliittyma = new Kayttoliittyma(robotti);
		
		kayttoliittyma.kaynnista();
	}

}
