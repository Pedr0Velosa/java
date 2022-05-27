package br.com.fiap.ig;


import javax.swing.JTextArea;

public class MeuTextArea extends JTextArea{

	private static final long serialVersionUID = 1L;

	private int colunas = 18;
	private int linhas = 5;
	
	public MeuTextArea() {
		init();
	}
	
	public void init() {
		this.setColumns(colunas);
		this.setRows(linhas);
	}
	
}