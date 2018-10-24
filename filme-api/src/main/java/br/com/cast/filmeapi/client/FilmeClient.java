package br.com.cast.filmeapi.client;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import br.com.cast.filmeapi.dtos.FilmeDTO;
import br.com.cast.filmeapi.dtos.ResultsDTO;

@Component
public class FilmeClient {
	
	final private String URL_BUSCAR_OMDBID = "http://www.omdbapi.com/?i={omdbID}&type=movie&apikey={appkey}";
			
	final private String URL_BUSCAR_LISTA = "http://www.omdbapi.com/?s={titulo}&type=movie&apikey={appkey}";
	final private String APP_ID = "92885882";
	private RestTemplate restTemplate;
	public FilmeClient() {
		restTemplate = new RestTemplate();
	}
	
	public FilmeDTO getFilmePorTitulo(String titulo){
		ResponseEntity<FilmeDTO> dtos = restTemplate.getForEntity(URL_BUSCAR_LISTA, FilmeDTO.class, titulo, APP_ID);
		return dtos.getBody();
	}

	public ResultsDTO getFilmePorOmdbID(String omdbID) {
		ResponseEntity<ResultsDTO> filmeDto =restTemplate.getForEntity(URL_BUSCAR_OMDBID, ResultsDTO.class, omdbID, APP_ID);
		ResultsDTO resultado = filmeDto.getBody();
		if(resultado.getTitle() == null) {
			return null;
		}
		 	return resultado;
	}
}
