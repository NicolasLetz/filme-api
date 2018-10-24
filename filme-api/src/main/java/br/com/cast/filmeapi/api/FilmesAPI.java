package br.com.cast.filmeapi.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.cast.filmeapi.business.FilmeBusiness;
import br.com.cast.filmeapi.dtos.ResultsDTO;

@RestController
@RequestMapping("/")
public class FilmesAPI {
	@Autowired
	private FilmeBusiness filmeBusiness;
	
	//PARA BUSCAR USANDO PARAMETRO S(DEPOIS DE BUSCAR NO BD E O USER CLICAR EM +)
	@RequestMapping(path="{titulo}", method = RequestMethod.GET)
	public List<ResultsDTO> getFilmeByTitleNaAPI(@PathVariable("titulo") String titulo) {
		return filmeBusiness.buscarPorTituloNaAPI(titulo);
	}
	//PARA BUSCAR TODOS OS FILMES DO BANDO DE DADOS(PARA A PAGINA INICIAL)
	@RequestMapping(path="movies", method = RequestMethod.GET)
	public List<ResultsDTO> getFilmesInDB() {
		return filmeBusiness.buscarTodosNoDB();
	}
	
	//QUANDO O USER DIGITAR NO INPUT E DER BUSCAR
	@RequestMapping(path="movies/{titulo}", method= RequestMethod.GET)
	public List<ResultsDTO> getFilmeByTitleInDB(@PathVariable("titulo") String titulo) {
		titulo = titulo.toLowerCase();
		return filmeBusiness.buscarPorTituloNoBD(titulo);
	}
}
