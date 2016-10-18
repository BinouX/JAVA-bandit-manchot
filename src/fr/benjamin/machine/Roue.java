package fr.benjamin.machine;

public class Roue extends Thread implements IRoue {
	private int wheel = 0;
	private int vitesse;// = 150;
	private final int STOP = 500;
	private boolean isStop = false;
	private boolean slow = false;

	public void run() {
		this.turnWheel();
	}

	public Roue(/* int wheel ,boolean newLine */) {
		// this.wheel = wheel;
		// this.newLine = newLine;
	}

	public int getWheel() {
		return wheel;
	}

	public void setWheel(int wheel) {
		this.wheel = wheel;
	}

	public int getVitesse() {
		return vitesse;
	}

	public void setVitesse(int vitesse) {
		this.vitesse = vitesse;
	}

	public boolean isStop() {
		return isStop;
	}

	public void setStop(boolean isStop) {
		this.isStop = isStop;
	}

	public int getSTOP() {
		return STOP;
	}

	public boolean isSlow() {
		return slow;
	}

	public void setSlow(boolean slow) {
		this.slow = slow;
	}

	@SuppressWarnings("static-access")
	@Override
	public int turnWheel() {
		while (true) {
			wheel++;
			if (wheel >= 10) {
				wheel = 0;
			}
			try {
				Thread.currentThread().sleep(vitesse);
//				if (this.isSlow()) {
					vitesse += 10;
//				}
				if (vitesse > STOP) {
					break;
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		Thread.currentThread().interrupt();
		this.setStop(true);
		return wheel;
	}
}
