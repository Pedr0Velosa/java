package br.com.fiap.ig.controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.fiap.ig.Janela;
import br.com.fiap.ig.dao.FilmeDao;
import br.com.fiap.ig.model.Filme;

public class BotaoListener implements ActionListener {

	private Janela view;
	private FilmeDao dao = new FilmeDao();
	
	public BotaoListener(Janela view) {
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		Filme filme = new Filme();
		filme.setTitulo(view.getTxtTitulo().getText());
		filme.setSinopse(view.getTxtSinopse().getText());
		filme.setPlataforma(view.getPlataforma());
		filme.setGenero(view.getGenero());
		filme.setAssistido(view.getAssistido());
		filme.setAvalicao(view.getAvalicao());

		dao.inserir(filme);
		
		view.carregarDados();
		view.setTxtTitulo("");	
		view.setTxtSinopse("");	
		
		List<Filme> lista = dao.listarTodos();
	}

}
