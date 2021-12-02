package com.geolane.model;

import java.util.List;

public class DB {

    private Boolean success;
    private List<Meme> memes;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public List<Meme> getMemes() {
        return memes;
    }

    public void setMemes(List<Meme> memes) {
        this.memes = memes;
    }
}
