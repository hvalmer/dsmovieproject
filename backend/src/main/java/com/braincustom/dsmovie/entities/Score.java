package com.braincustom.dsmovie.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="tb_score")
public class Score {

	//new garante que o objeto estará instanciado
	@EmbeddedId
	private ScorePK id = new ScorePK();	
	
	private Double value;
	
	public Score() {
	}

	/*o id é do tipo ScorePK;
	 * o ScorePK por sua vez, que tem a referência do movie e do user;
	 * chamando o setMovie() e o setUser() pra salvar a referência no ScorePK
	 * */
	public void setMovie(Movie movie) {
		id.setMovie(movie);
	}
	
	public void setUser(User user) {
		id.setUser(user);
	}
	
	public ScorePK getId() {
		return id;
	}

	public void setId(ScorePK id) {
		this.id = id;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}
	
	
}
