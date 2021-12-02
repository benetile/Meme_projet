package com.geolane.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "memes")
public class Meme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMeme;
   // @Column(name = "id")
    private Long id;
    private String name;
    private String url;
    private int width;
    private int height;
    private int box_count;

    public Meme() {
    }

    public Meme(Long idMeme, String name, String url, int width, int height, int box_count) {
        this.idMeme = idMeme;
        this.name = name;
        this.url = url;
        this.width = width;
        this.height = height;
        this.box_count = box_count;
    }

    public Long getIdMeme() {
        return idMeme;
    }

    public void setIdMeme(Long idMeme) {
        this.idMeme = idMeme;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getBox_count() {
        return box_count;
    }

    public void setBox_count(int box_count) {
        this.box_count = box_count;
    }
}
