package br.com.cast.filmeapi.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.cast.filmeapi.client.FilmeClient;
import br.com.cast.filmeapi.dtos.DetalheFilmeDTO;
import br.com.cast.filmeapi.entidades.DetalheFilme;
import br.com.cast.filmeapi.repositorios.DetalheFilmeRepository;

@Component
public class DetalheFilmeBusiness {
	
	@Autowired
	private FilmeClient filmeClient;
	@Autowired
	private DetalheFilmeRepository detalheFilmeRepository;
	
	@Transactional
	public DetalheFilmeDTO buscarPorImdbID(String imdbID) {
		DetalheFilme detalheFilme = detalheFilmeRepository.buscarPorImdbID(imdbID);
		DetalheFilmeDTO detalheFilmeDTO = new DetalheFilmeDTO();
		if(detalheFilme == null) {
			detalheFilme = new DetalheFilme();
			detalheFilmeDTO = filmeClient.getDetailByImdbID(imdbID);
			detalheFilme.setActors(detalheFilmeDTO.getActors());
			detalheFilme.setCountry(detalheFilmeDTO.getCountry());
			detalheFilme.setDirector(detalheFilmeDTO.getDirector());
			detalheFilme.setGenre(detalheFilmeDTO.getGenre());
			detalheFilme.setImdbID(detalheFilmeDTO.getImdbID());
			detalheFilme.setImdbRating(detalheFilmeDTO.getImdbRating());
			detalheFilme.setImdbVotes(detalheFilmeDTO.getImdbVotes());
			detalheFilme.setLanguage(detalheFilmeDTO.getLanguage());
			detalheFilme.setPlot(detalheFilmeDTO.getPlot());
			detalheFilme.setPoster(detalheFilmeDTO.getPoster());
			detalheFilme.setReleased(detalheFilmeDTO.getReleased());
			detalheFilme.setResponse(detalheFilmeDTO.getResponse());
			detalheFilme.setRuntime(detalheFilmeDTO.getRuntime());
			detalheFilme.setTitle(detalheFilmeDTO.getTitle());
			detalheFilme.setWriter(detalheFilmeDTO.getWriter());
			detalheFilme.setYear(detalheFilmeDTO.getYear());
			detalheFilmeRepository.inserir(detalheFilme);
		}else {
			detalheFilmeDTO.setActors(detalheFilme.getActors());
			detalheFilmeDTO.setCountry(detalheFilme.getCountry());
			detalheFilmeDTO.setDirector(detalheFilme.getDirector());
			detalheFilmeDTO.setGenre(detalheFilme.getGenre());
			detalheFilmeDTO.setImdbID(detalheFilme.getImdbID());
			detalheFilmeDTO.setImdbRating(detalheFilme.getImdbRating());
			detalheFilmeDTO.setImdbVotes(detalheFilme.getImdbVotes());
			detalheFilmeDTO.setLanguage(detalheFilme.getLanguage());
			detalheFilmeDTO.setPlot(detalheFilme.getPlot());
			detalheFilmeDTO.setPoster(detalheFilme.getPoster());
			detalheFilmeDTO.setReleased(detalheFilme.getReleased());
			detalheFilmeDTO.setResponse(detalheFilme.getResponse());
			detalheFilmeDTO.setRuntime(detalheFilme.getRuntime());
			detalheFilmeDTO.setTitle(detalheFilme.getTitle());
			detalheFilmeDTO.setWriter(detalheFilme.getWriter());
			detalheFilmeDTO.setYear(detalheFilme.getYear());
		}
		return detalheFilmeDTO;
	}
}
