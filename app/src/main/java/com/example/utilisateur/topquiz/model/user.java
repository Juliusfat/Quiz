package com.example.utilisateur.topquiz.model;

/**
 * Created by utilisateur on 06/01/2018.
 */

public class user {

    private String mFirstName;
    private Integer mscore;
    private Long idUser;


    public String getFirstName() {
        return mFirstName;
    }

    public void setFirstName(String firstName) {
        mFirstName = firstName;
    }

    public Integer getMscore() {
        return mscore;
    }

    public void setMscore(Integer mscore) {
        this.mscore = mscore;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public user(){

    }

    public user(String firstName, Integer score, Long idUser) {
        mFirstName = firstName;
        this.mscore = score;
        this.idUser = idUser;
    }

    @Override
    public String toString() {
        return "user{" +
                "mFirstName='" + mFirstName + '\'' +
                ", mscore=" + mscore +
                ", idUser=" + idUser +
                '}';
    }
}
