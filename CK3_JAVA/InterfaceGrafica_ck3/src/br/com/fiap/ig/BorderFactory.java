package br.com.fiap.ig;

import java.awt.Color;

import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public abstract class BorderFactory {

	public static Border create(int r,int g,int b) {
		return new LineBorder(new Color(r,g,b));
	}
	
}
