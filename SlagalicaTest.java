package com.jelena.slagalica;

import java.awt.Container;

import javax.swing.JFrame;


public class SlagalicaTest extends JFrame{
	
	public SlagalicaTest(){
		super("Slagalica");
		Slagalica ps  = new Slagalica("češkanje");
		Container contentPane = getContentPane();
		contentPane.add(ps);
		setSize(700,300);
		setVisible(true);
	}

	public static void main(String[] args) {
		SlagalicaTest st = new SlagalicaTest();
		st.setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

}
