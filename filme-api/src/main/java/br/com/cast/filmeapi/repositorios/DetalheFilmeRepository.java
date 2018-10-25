package br.com.cast.filmeapi.repositorios;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.cast.filmeapi.entidades.DetalheFilme;

@Repository
public class DetalheFilmeRepository {
	
	@PersistenceContext
	EntityManager entityManager;
	
	public DetalheFilme buscarPorImdbID(String imdbID) {
		return entityManager.find(DetalheFilme.class, imdbID);
	}

	public void inserir(DetalheFilme detalheFilme) {
		entityManager.persist(detalheFilme);
	}
}
