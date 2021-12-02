package com.geolane.service;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import com.geolane.model.DB;
import com.geolane.model.Meme;
import com.geolane.repository.MemeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Service
public class MemeService {

    public static List<Meme> memes = new ArrayList<>();

    /** J'ai crée une méthode static pour récupérer les données du fichier Geolane.json pour les attribuer à une Liste de meme à chaque demarage du programme*/
    static {
        File file = new File("Geolane.json");
        DB db;
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        mapper.setVisibility(VisibilityChecker.Std.defaultInstance().withCreatorVisibility(JsonAutoDetect.Visibility.ANY));

        try {
            db = mapper.readValue(file,DB.class);
            memes.addAll(db.getMemes());
            for (Meme m: db.getMemes()) {
                System.out.println(m.getName());
                System.out.println(m.getUrl());
            }
            System.out.println(" Contient une liste de "+memes.size()+ " Memes");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Meme> getMemes() {
        return memes;
    }
}
