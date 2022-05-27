package br.com.fiap.ig;

import java.awt.Color;

import javax.swing.JTextField;

public class Input extends JTextField{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Input() {
		super(20);
	}
	
	public Input(int r, int g, int b) {
		super(20);
		init(r, g, b);
	}
	
	private void init(int r, int g, int b) {
		this.setForeground(new Color(0, 0 ,0));//color
		this.setBackground(new Color(255,255,255));//background-color
		this.setBorder(BorderFactory.create(r,g,b));	
	}
	
}
