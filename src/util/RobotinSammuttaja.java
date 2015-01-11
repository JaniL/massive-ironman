package util;
import lejos.nxt.Button;
import lejos.nxt.ButtonListener;

/**
 * 
 * @author Jani Luukko <jani.luukko@cs.helsinki.fi>
 *
 */
public class RobotinSammuttaja implements ButtonListener {

	@Override
	public void buttonPressed(Button b) {
		System.out.println("Viivanseuraaja sulkeutuu!");
		System.exit(0);
	}

	@Override
	public void buttonReleased(Button b) {
		return;
	}

}
