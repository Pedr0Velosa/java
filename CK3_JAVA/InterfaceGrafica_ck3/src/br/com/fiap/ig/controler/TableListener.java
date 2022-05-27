package br.com.fiap.ig.controler;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import br.com.fiap.ig.Janela;

public class TableListener implements MouseListener{
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getClickCount() == 2) {
			int resposta = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja apagar esse filme da lista?");
			if(resposta == JOptionPane.YES_OPTION) {
				System.out.println("1312312312");
				JTable tabela = (JTable) e.getSource();
				int id = tabela.getSelectedRow();
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
