package com.jelena.slagalica;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;

public class ButtonSlovo extends JButton {
	private char slovo;
	
	public ButtonSlovo () { 
		super("?");	
		slovo ='?';
		Color myColor = new Color (193, 255, 193);  //http://cloford.com/resources/colours/500col.htm
		setBackground(myColor);
		setFont(new Font("Arial", Font.BOLD, 16));	
		setPreferredSize(new Dimension(30, 30));
	}
	
	public ButtonSlovo (char slovo) { 
		
		super(Character.toString(slovo));		
		Color myColor = new Color (193, 255, 193);  //http://cloford.com/resources/colours/500col.htm
		setBackground(myColor);
		setFont(new Font("Arial", Font.BOLD, 16));	
		setPreferredSize(new Dimension(30, 30));
		System.out.println("pozvan konstruktor ButtonSLovo(char slovo)");
	}
	public void setSlovo(char c) {
		slovo = c;
		this.setText(Character.toString(slovo));
	}
	public char getSlovo(){
		return slovo;
	}
	

}
