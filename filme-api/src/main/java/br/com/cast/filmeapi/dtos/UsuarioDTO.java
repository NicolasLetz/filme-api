package br.com.cast.filmeapi.dtos;

import java.util.List;

import br.com.cast.filmeapi.entidades.Comentario;

public class UsuarioDTO {
	private String nome;
	private String user;
	private String senha;
	private List<ComentarioDTO> comentarios;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
}