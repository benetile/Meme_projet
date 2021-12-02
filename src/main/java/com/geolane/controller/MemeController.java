package com.geolane.controller;

import com.geolane.model.Meme;
import com.geolane.repository.MemeRepository;
import com.geolane.service.MemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class MemeController {

    @Autowired
    private MemeRepository memeRepository;
    @Autowired
    private MemeService memeService;

    /** Ce controller permet d'afficher la liste des memes récuperer en static das notre ficihier Geolane.json à chaque démarrage du programme*/
    @GetMapping("/memes")
    public String showAll(Model model){
      model.addAttribute("memes",memeService.getMemes());
      return "memes";
    }
    /** Notre page d'acceuil*/
    @GetMapping("/")
    public String createMeme(){
        return "home";
    }

    /**
     * Ce controller a pour but d'enregistrer tous les memes qui seront récupérer dans notre fichier json
     * @param model
     * @return une liste des memes qui avec des clés primaires
     */
    @GetMapping("/saveAll")
    public String saveAllMeme(Model model){
        memeRepository.saveAll(memeService.getMemes());
        List<Meme> memes = memeRepository.findAll();
        String message = "La sauvegarde de "+memes.size()+ " memes a été un succès";
        model.addAttribute("memes",memes);
        model.addAttribute("message",message);
        return "memes";
    }

    /**  Ce controller sert a afficher le formaulaire qui nous permettra d'enregistrer un nouveau meme manuellement */
    @GetMapping("/add")
    public String createAMeme(Model model){
        model.addAttribute("meme",new Meme());
        return "addMeme";
    }

    /**  Ce controller sert a ajouter manuellement un meme dans la base de donnée */
    @PostMapping("/add")
    public String addMeme(@Valid Meme meme, Model model){
       if (memeRepository.findByName(meme.getName())== null){
           memeRepository.save(meme);
           Meme saveMeme = memeRepository.findByName(meme.getName());
           System.out.println(saveMeme.getId());
           System.out.println(saveMeme.getName());
           System.out.println(saveMeme.getUrl());

           model.addAttribute("meme",saveMeme);
           return "meme";
       }
       else
           return "addMeme";
    }

}
