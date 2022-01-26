package com.braincustom.dsmovie.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.braincustom.dsmovie.dto.MovieDTO;
import com.braincustom.dsmovie.dto.ScoreDTO;
import com.braincustom.dsmovie.entities.Movie;
import com.braincustom.dsmovie.entities.Score;
import com.braincustom.dsmovie.entities.User;
import com.braincustom.dsmovie.repositories.MovieRepository;
import com.braincustom.dsmovie.repositories.ScoreRepository;
import com.braincustom.dsmovie.repositories.UserRepository;

@Service //registra o ScoreService como componente do sistema
public class ScoreService {

	@Autowired //precisando de um objeto, a anotation traz o objeto sem precisar instanciar(new)
	private MovieRepository movieRepository;
	
	@Autowired //precisando de um objeto, a anotation traz o objeto sem precisar instanciar(new)
	private UserRepository userRepository;
	
	@Autowired //precisando de um objeto, a anotation traz o objeto sem precisar instanciar(new)
	private ScoreRepository scoreRepository;
	
	//método para salvar um novo score no BD a partir do objeto ScoreDTO
	@Transactional //garante a transação com o BD
	public MovieDTO saveScore(ScoreDTO dto) {
		
		//recuperar o usuário do BD por email. 
		User user = userRepository.findByEmail(dto.getEmail());
		//Se não existir, inserir o novo email no BD
		if(user == null) {
			user = new User();
			user.setEmailString(dto.getEmail());
			user = userRepository.saveAndFlush(user);
		}
		
		Movie movie = movieRepository.findById(dto.getMovieId()).get();
		
		//Salvar a avaliação do usuário para o dado filme
		//preparado em memória com os três dados
		Score score = new Score();
		score.setMovie(movie);
		score.setUser(user);
		score.setValue(dto.getScore());//salvando a nota do score
		
		score = scoreRepository.saveAndFlush(score);
		
		double sum = 0.0;
		//acessando a lista de scores associado a um filme
		//fazendo um for para percorrer todos os scores dentro de um certo filme
		for (Score s : movie.getScores()) {
			sum = sum + s.getValue();
		}
		//calculando a média
		double avg = sum / movie.getScores().size();
		//salvando a contagem
		movie.setScore(avg);
		movie.setCount(movie.getScores().size());
		//salvando o movie no BD
		movie = movieRepository.save(movie);
		
		return new MovieDTO(movie);
	}
}
