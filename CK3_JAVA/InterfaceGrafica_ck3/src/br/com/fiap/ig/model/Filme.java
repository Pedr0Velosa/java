package br.com.fiap.ig.model;

import java.util.Vector;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Filme {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titulo;
	private String sinopse;
	private String genero;

	private String plataforma;
	private String assistido;
	private String avaliacao;

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}

	public void setAssistido(boolean assistido) {
		if(assistido) {
			this.assistido = "assistido";
		}else {
			this.assistido = "Não assistido";
		}
	}

	public void setAvalicao(int avaliacao) {
		this.avaliacao = String.valueOf(avaliacao);
	}

	@Override
	public String toString() {
		return "Filme [titulo=" + titulo + ", sinopse=" + sinopse + ", genero=" + genero + ", plataforma=" + plataforma
				+ ", assistido=" + assistido + ", avalicao=" + avaliacao + "]";
	}

	public Vector<String> getData() {
		
		Vector<String> data = new Vector<String>();
		data.add(id.toString());
		data.add(titulo);
		data.add(sinopse);
		data.add(genero);
		data.add(plataforma);
		data.add(assistido);
		data.add(avaliacao);
		
		return data;
	}

}
