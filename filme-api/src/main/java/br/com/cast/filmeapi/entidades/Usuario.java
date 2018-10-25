package br.com.cast.filmeapi.entidades;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(schema="filmes", name="usuario")
public class Usuario {
	@Id
	@SequenceGenerator(allocationSize=1, initialValue=1, name="idSeqGen", sequenceName="user_id_seq", schema="filmes")
	@GeneratedValue(generator="idSeqGen", strategy= GenerationType.SEQUENCE)
	private Integer id;
	private String nome;
	private String user;
	private String senha;
	private List<Comentario> comentarios;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
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
