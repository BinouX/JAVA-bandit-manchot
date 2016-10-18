package fr.benjamin.userenter;

import java.util.Scanner;

import fr.benjamin.affichage.ShowAllWheel;
import fr.benjamin.machine.Roue;

public class StopWheel extends Thread {
	private String charStop;
	private Roue roue;
	private ShowAllWheel showWheel;

	public void run(){
		this.wheelStopThread();
	}
	
	public StopWheel(ShowAllWheel showWheel) {
		this.showWheel = showWheel;
	}

	public String getCharStop() {
		return charStop;
	}

	public void setCharStop(String charStop) {
		this.charStop = charStop;
	}

	public Roue getRoue() {
		return roue;
	}

	public void setRoue(Roue roue) {
		this.roue = roue;
	}

	@SuppressWarnings("resource")
	public void wheelStopThread() {
		while (true) {
			System.out.println(showWheel.showValue());
			Scanner keyboard = new Scanner(System.in);
			String input = keyboard.nextLine();
			if (input == charStop) {
				roue.setSlow(true);
				Thread.currentThread().interrupt();
				break;
			}
		}
	}
}
