package fr.benjamin.machine;

import java.io.IOException;
import java.util.Scanner;

import fr.benjamin.affichage.ShowAllWheel;
import fr.benjamin.userenter.StopWheel;

public class Machine implements IMachine {
	private int recover;

	@SuppressWarnings("resource")
	@Override
	public void recoverMoney() {
		System.out.println("Combien voulez-vous parier?");
		Scanner sc = new Scanner(System.in);
		recover = sc.nextInt();
		System.out.println("Vous avez inséré " + recover + "€");
		this.launchWheel();
	}

	@SuppressWarnings("static-access")
	@Override
	public void launchWheel() {

		Roue roue0 = new Roue();
		roue0.setVitesse((int) (Math.random() * 200));
		Roue roue1 = new Roue();
		roue1.setVitesse((int) (Math.random() * 200));
		Roue roue2 = new Roue();
		roue2.setVitesse((int) (Math.random() * 200));
		Roue roue3 = new Roue();
		roue3.setVitesse((int) (Math.random() * 200));

		roue0.start();
		roue1.start();
		roue2.start();
		roue3.start();

		ShowAllWheel showWheel = new ShowAllWheel(roue0, roue1, roue2, roue3);

		
		
		while (!roue0.isStop() || !roue1.isStop() || !roue2.isStop() || !roue3.isStop()) {
			
			//test de clear la console pour pouvoir afficher toujours sur la meme ligne
			try {
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
				System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println(showWheel.showValue());
			try {
				Thread.currentThread().sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		winner(roue0.getWheel(), roue1.getWheel(), roue2.getWheel(), roue3.getWheel());
	}

	@Override
	public void winner(int x0, int x1, int x2, int x3) {
		if (x0 == x1 && x0 == x2 && x0 == x3) {
			System.out.println("Vous avez gagné");
			returnMoney(x0);
		} else {
			System.out.println("Vous avez perdu!");
			replay();
		}
	}

	@Override
	public void returnMoney(int x) {
		if (x == 7) {
			this.recover = this.recover * 100;
		} else if (x == 9 || x == 8) {
			this.recover = this.recover * 50;
		} else if (x < 7 && x > 2) {
			this.recover = this.recover * 25;
		} else if (x <=2) {
			this.recover = this.recover * 10;
		}
		replay();
	}

	@Override
	public void replay() {
		Scanner key = new Scanner(System.in);
		System.out.println("Voulez vous rejouer? (y/N)");
		String k = key.nextLine();
		if(k.equals("y")){
			this.recoverMoney();
		}else{
			System.exit(0);
		}
	}

}
