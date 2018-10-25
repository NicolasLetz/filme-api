package br.com.cast.filmeapi.entidades;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;
@Entity
@Table(name="comentarios", schema="filmes")
public class Comentario {
	@Id
	@SequenceGenerator(name="idSeqGenCom", sequenceName="comentario_id_seq", allocationSize=1, initialValue=1, schema="filmes")
	@GeneratedValue(generator="idSeqGenCom", strategy= GenerationType.SEQUENCE)
	private Integer id;
	private Filme filme;
	@ManyToOne
	private Usuario usuario;
	private String conteudo;
	private Date data;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Filme getFilme() {
		return filme;
	}
	public void setFilme(Filme filme) {
		this.filme = filme;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public String getConteudo() {
		return conteudo;
	}
	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
}
