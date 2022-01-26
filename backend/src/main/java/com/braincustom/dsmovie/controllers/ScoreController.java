package com.braincustom.dsmovie.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.braincustom.dsmovie.dto.MovieDTO;
import com.braincustom.dsmovie.dto.ScoreDTO;
import com.braincustom.dsmovie.services.ScoreService;

@RestController
@RequestMapping(value="/scores")
public class ScoreController {

	@Autowired
	private ScoreService service;
	
	//Anothation Put para salvar idempotente, ou seja, salva a mesma coisa várias vezes, tem o mesmo efeito de salvar apenas uma vez
	@PutMapping
	public MovieDTO saveScore(@RequestBody ScoreDTO dto){
		MovieDTO movieDTO = service.saveScore(dto);
		return movieDTO;
	}
}
