package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
public class HomeCtrl {

    @Autowired
    CardRepository cardRepository;

    Deck deckofcard = new Deck(4);


    public ArrayList<Card> convertToArray(Deck carddeck) {
        ArrayList<Card> cards = new ArrayList<Card>();
        Card tmpcard;

        for (int i = 0; i < carddeck.getMaxrow(); i++) {
            for (int j = 0; j < carddeck.getMaxrow(); j++) {
                tmpcard = carddeck.getCard(i, j);
                cards.add(tmpcard);
            }
        }

        return cards;
    }

    @RequestMapping("/")
    public String homepage(Model model) {
        ArrayList<Card> cards;
        String msg = "Select a card.";

        cards = deckofcard.shuffleCards();

        for (Card tmpcard : cards) {
            cardRepository.save(tmpcard);
        }
        cards = cardRepository.findAllByOrderByCardposition();
        model.addAttribute("allcards", cards);
        model.addAttribute("msg", msg);


        model.addAttribute("disableflag", 0);
//        return "showcards";
        return "twocards";
    }

    @RequestMapping("/test")
    public String test(Model model) {
        ArrayList<Card> cards;
        Card firstcard, secondcard;

        cards = deckofcard.shuffleCards();

        for (Card tmpcard : cards) {
            cardRepository.save(tmpcard);
        }
        firstcard = cardRepository.findCardByCardpositionEquals(1);
        secondcard = cardRepository.findCardByCardpositionEquals(2);
        model.addAttribute("firstcard", firstcard);
        model.addAttribute("card2", secondcard);

        return "twocards";
    }
}
