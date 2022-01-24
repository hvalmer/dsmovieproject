package com.braincustom.dsmovie.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.braincustom.dsmovie.dto.MovieDTO;
import com.braincustom.dsmovie.services.MovieService;

@RestController
@RequestMapping(value="/movies")
public class MovieController {

	//o controller depende do movieService
	@Autowired
	private MovieService service;
	
	//método para retornar a página de filmes
	@GetMapping //o método responde pela requisição Get do Http(/movies)
	public Page<MovieDTO> findAll(Pageable pageable){
		return service.findAll(pageable);
	}
	
	//método para retornar uma consulta simples por id
	@GetMapping(value="/{id}") //o método para retorna uma consulta por id
	public MovieDTO findById(@PathVariable Long id){
		return service.findById(id);
	}
}
