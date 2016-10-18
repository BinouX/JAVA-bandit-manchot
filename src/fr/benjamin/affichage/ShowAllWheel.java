package fr.benjamin.affichage;

import fr.benjamin.machine.Roue;

public class ShowAllWheel {
	private Roue roue0 = null;
	private Roue roue1 = null;
	private Roue roue2 = null;
	private Roue roue3 = null;
	
	public ShowAllWheel(Roue roue0, Roue roue1, Roue roue2, Roue roue3){
		this.roue0 = roue0;
		this.roue1 = roue1;
		this.roue2 = roue2;
		this.roue3 = roue3;
	}
	
	public String showValue(){
		StringBuilder builder = new StringBuilder();
		builder.append(roue0.getWheel());
		builder.append("|");
		builder.append(roue1.getWheel());
		builder.append("|");
		builder.append(roue2.getWheel());
		builder.append("|");
		builder.append(roue3.getWheel());
		return builder.toString();
	}
}
