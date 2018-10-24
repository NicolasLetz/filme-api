package br.com.cast.filmeapi.dtos;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FilmeDTO {
	@JsonProperty("Search")
	private List<SearchDTO> search;
	private String totalResults;
	@JsonProperty("Response")
	private String response;
	
	public List<SearchDTO> getSearch() {
		return search;
	}
	public void setSearch(List<SearchDTO> search) {
		this.search = search;
	}
	public String getTotalResults() {
		return totalResults;
	}
	public void setTotalResults(String totalResults) {
		this.totalResults = totalResults;
	}
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}
}