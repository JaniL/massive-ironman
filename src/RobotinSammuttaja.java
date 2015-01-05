import lejos.nxt.Button;
import lejos.nxt.ButtonListener;


public class RobotinSammuttaja implements ButtonListener {

	@Override
	public void buttonPressed(Button b) {
		// TODO Auto-generated method stub
		System.out.println("Viivanseuraaja sulkeutuu!");
		System.exit(0);
	}

	@Override
	public void buttonReleased(Button b) {
		// TODO Auto-generated method stub
		return;
	}

}
