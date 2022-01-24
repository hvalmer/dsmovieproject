package com.braincustom.dsmovie.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class ScorePK implements Serializable {//esse objeto(ScorePK) pode ser convertido para bytes, Serializable
	private static final long serialVersionUID = 1L;

	//as associações, referências, sendo identificador dos objetos
	//das tabelas Movie e User (muitos para muitos), sendo criada 
	//para unir as duas tabelas
	//configurando a chave estrangeira @ para fazer referência ao filme e ao usuário
	@ManyToOne
	@JoinColumn(name="movie_id")
	private Movie movie;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	public ScorePK() {
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
