package br.com.cast.filmeapi.repositorios;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.cast.filmeapi.entidades.Filme;

@Repository
public class FilmeRepository {
	@PersistenceContext
	EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	public List<Filme> buscarTodos() {
		StringBuilder jpql = new StringBuilder();
		jpql.append("FROM ").append(Filme.class.getName());
		Query query = entityManager.createQuery(jpql.toString());
		return query.getResultList();
	}

	public List<Filme> buscarPorTitulo(String titulo) {
		StringBuilder jpql = new StringBuilder();
		jpql.append("FROM ").append(Filme.class.getName()).append(" f WHERE lower(title) LIKE :titulo "
																		+ "OR upper(title) LIKE :titul");
		Query query = entityManager.createQuery(jpql.toString());
		query.setParameter("titulo", "%"+titulo+"%");
		query.setParameter("titul", "%"+titulo+"%");
		
		@SuppressWarnings("unchecked")
		List<Filme> filmes = query.getResultList();
		return filmes.size()>0 ? filmes : null;
	}
	public void inserir(Filme filme) {
		entityManager.persist(filme);
	}

	public Filme buscarPorOmdbID(String omdbID) {
		return entityManager.find(Filme.class, omdbID);
	}
}
