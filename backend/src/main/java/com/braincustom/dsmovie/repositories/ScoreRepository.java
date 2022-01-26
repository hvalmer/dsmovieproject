package com.braincustom.dsmovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.braincustom.dsmovie.entities.Score;
import com.braincustom.dsmovie.entities.ScorePK;

public interface ScoreRepository extends JpaRepository<Score, ScorePK> {
}
