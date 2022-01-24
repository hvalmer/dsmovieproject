package com.braincustom.dsmovie.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.braincustom.dsmovie.dto.MovieDTO;
import com.braincustom.dsmovie.entities.Movie;
import com.braincustom.dsmovie.repositories.MovieRepository;

@Service //registra o MovieService como componente do sistema
public class MovieService {

	@Autowired //precisando de um objeto, a anotation traz o objeto sem precisar instanciar(new)
	private MovieRepository repository;
	
	//a resposta do método vai ser uma lista simples DTO
	@Transactional(readOnly = true) //garante que toda transação na camada de serviço seja resolvido
	public Page<MovieDTO> findAll(Pageable pageable) {
		//o retorno da consulta do BD(repository) vai ser uma lista de Movie
		//busca paginada para entregar um número determinado de filmes numa lista
		Page<Movie> result = repository.findAll(pageable);
		//convertendo Movie para MovieDTO
		Page<MovieDTO> page = result.map(x -> new MovieDTO(x));
		return page;
	}

	//retornando apenas uma consulta por id
	@Transactional(readOnly = true) //garante que toda transação na camada de serviço seja resolvido
	public MovieDTO findById(Long id) {
		Movie result = repository.findById(id).get();
		//convertendo para MovieDTO
		MovieDTO dto = new MovieDTO(result);
		return dto;
	}
}
