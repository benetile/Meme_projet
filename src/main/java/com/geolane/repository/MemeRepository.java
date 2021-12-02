package com.geolane.repository;

import com.geolane.model.Meme;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemeRepository extends JpaRepository<Meme,Long> {

    Optional<Meme> findByIdMeme(Long id);

    Meme findByName(String name);

    Meme findByUrl(String url);
}
