package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String facecard;
    private String backcard;
    private int cardval;
    private int cardposition;
    private boolean found;   // true is if matching card has been found
    private boolean facingfront;    // true if card is facing front

    public Card() {
        this.facecard = null;
        this.backcard = null;
        this.cardval = 0;
        this.cardposition = -1;
        this.found = false;
        this.facingfront = false;
    }

    public Card(String frontcard, String backcard) {
        this.facecard = frontcard;
        this.backcard = backcard;
        this.cardval = 0;
        this.cardposition = -1;
        this.found = false;
        this.facingfront = false;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFacecard() {
        return facecard;
    }

    public void setFacecard(String facecard) {
        this.facecard = facecard;
    }

    public String getBackcard() {
        return backcard;
    }

    public void setBackcard(String backcard) {
        this.backcard = backcard;
    }

    public int getCardval() {
        return cardval;
    }

    public void setCardval(int cardval) {
        this.cardval = cardval;
    }

    public int getCardposition() {
        return cardposition;
    }

    public void setCardposition(int cardposition) {
        this.cardposition = cardposition;
    }

    public boolean isFound() {
        return found;
    }

    public void setFound(boolean found) {
        this.found = found;
    }

    public boolean isFacingfront() {
        return facingfront;
    }

    public void setFacingfront(boolean facingfront) {
        this.facingfront = facingfront;
    }
}
