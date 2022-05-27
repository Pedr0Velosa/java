package br.com.fiap.ig.dao;

import java.util.List;

import javax.persistence.*;

import br.com.fiap.ig.model.Filme;

public class FilmeDao {

	EntityManagerFactory factory = Persistence.createEntityManagerFactory("filmes");
	EntityManager manager = factory.createEntityManager();

	public void inserir(Filme filme) {

		manager.getTransaction().begin();
		manager.persist(filme);
		manager.getTransaction().commit();

	}

	public List<Filme> listarTodos() {
		String jpql = "SELECT f FROM Filme f";
		TypedQuery<Filme> query = manager.createQuery(jpql, Filme.class);

		return query.getResultList();
	}

	//public void apagar(Filme filme) {
		//manager.getTransaction().begin();
		//manager.remove(filme);
		//manager.getTransaction().commit();
	//}
}
