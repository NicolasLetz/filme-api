package br.com.cast.filmeapi.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.cast.filmeapi.client.FilmeClient;
import br.com.cast.filmeapi.dtos.FilmeDTO;
import br.com.cast.filmeapi.dtos.ResultsDTO;
import br.com.cast.filmeapi.entidades.Filme;
import br.com.cast.filmeapi.repositorios.FilmeRepository;
@Component
public class FilmeBusiness {

	@Autowired
	private FilmeClient filmeClient;
	@Autowired
	private FilmeRepository filmeRepository;
	
	@Transactional
	public List<ResultsDTO> buscarPorTituloNaAPI(String titulo) {
		List<ResultsDTO> respostas = new ArrayList<>();
		FilmeDTO filmeDto = filmeClient.getFilmePorTitulo(titulo);
		int tamanho = filmeDto.getSearch().size();
		for(int i = 0 ; i<tamanho; i++) {
			ResultsDTO resposta = new ResultsDTO();
			resposta.setImdbID(filmeDto.getSearch().get(i).getImdbID());
			resposta.setPoster(filmeDto.getSearch().get(i).getPoster());
			resposta.setResponse(filmeDto.getResponse());
			resposta.setTotalResults(filmeDto.getTotalResults());
			resposta.setTitle(filmeDto.getSearch().get(i).getTitle());
			resposta.setType(filmeDto.getSearch().get(i).getType());
			resposta.setYear(filmeDto.getSearch().get(i).getYear());
			respostas.add(resposta);
		}
		for (ResultsDTO result : respostas) {
			if(filmeClient.getFilmePorOmdbID(result.getImdbID())==null) {
				Filme filme = new Filme();
				filme.setImdbID(result.getImdbID());
				filme.setPoster(result.getPoster());
				filme.setResponse(result.getResponse());
				filme.setTitle(result.getTitle());
				filme.setTotalResults(result.getTotalResults());
				filme.setType(result.getType());
				filme.setYear(result.getYear());
				filmeRepository.inserir(filme);
			}
		}
		return respostas;
	}
	public List<ResultsDTO> buscarTodosNoDB() {
		List<ResultsDTO> resultados = new ArrayList<>();
		List<Filme> filmes = filmeRepository.buscarTodos();
		for (Filme filme : filmes) {
			ResultsDTO dto = new ResultsDTO();
			dto.setImdbID(filme.getImdbID());
			dto.setPoster(filme.getPoster());
			dto.setResponse(filme.getResponse());
			dto.setTitle(filme.getTitle());
			dto.setTotalResults(filme.getTotalResults());
			dto.setType(filme.getType());
			dto.setYear(filme.getYear());
			resultados.add(dto);
		}
		return resultados;
	}
	public List<ResultsDTO> buscarPorTituloNoBD(String titulo) {
		List<ResultsDTO> resultados = new ArrayList<>();
			List<Filme> filmes =filmeRepository.buscarPorTitulo(titulo);
			if(filmes != null) {
				for (Filme filme : filmes) {
					ResultsDTO result = new ResultsDTO();
					result.setImdbID(filme.getImdbID());
					result.setPoster(filme.getPoster());
					result.setResponse(filme.getResponse());
					result.setTitle(filme.getTitle());
					result.setTotalResults(filme.getTotalResults());
					result.setType(filme.getType());
					result.setYear(filme.getYear());
					resultados.add(result);
				}
			}
		return resultados;
	}
	
//	public void adicionaInDB(String omdbID) {
//		if(filmeRepository.buscarPorOmdbID(omdbID) == null) {
//			ResultsDTO resultDto = filmeClient.getFilmePorOmdbID(omdbID);
//			Filme filme = new Filme();
//			filme.setImdbID(resultDto.getImdbID());
//			filme.setPoster(resultDto.getPoster());
//			filme.setResponse(resultDto.getResponse());
//			filme.setTitle(resultDto.getTitle());
//			filme.setType(resultDto.getType());
//			filme.setYear(resultDto.getYear());
//			filme.setTotalResults("1");
//			filmeRepository.inserir(filme);
//		}
//	}
}
