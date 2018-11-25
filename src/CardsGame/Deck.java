package CardsGame;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    private ArrayList<Card> cards;

    public Deck() {
        this.cards = new ArrayList<>();
    }

    public void makeDeck(){
        for (Type type : Type.values()) {
            for (Value value : Value.values()) {
                cards.add(new Card(type,value));
            }
        }
    }

    public void shuffleDeck(){
        Collections.shuffle(cards);
    }

    public void drawCardFromDeck(Deck deckToDrawCard){
        cards.add(deckToDrawCard.getCard(0));
        deckToDrawCard.removeCard(0);
    }

    public Card getCard(int index){
        return cards.get(index);
    }

    private Card removeCard(int index){
        return cards.remove(index);
    }


    public void ifPlayerWins(Deck dealerDeck, Deck playerDeck){
        System.out.println("Player wins");
        System.out.println("Dealers score: "+dealerDeck.getCardValue());
        System.out.println("Yours score: "+playerDeck.getCardValue());
        System.out.println("Dealers cards were: "+dealerDeck.toString());
    }

    public void ifDealerWins(Deck dealerDeck, Deck playerDeck){
        System.out.println("Dealer wins");
        System.out.println("Dealers score: "+dealerDeck.getCardValue());
        System.out.println("Yours score: "+playerDeck.getCardValue());
        System.out.println("Dealers cards were: "+dealerDeck.toString());
    }

    public String toString(){
        String cardsToprint="";
        for (Card card : cards) {
            cardsToprint+=card.toString();
        }
        return cardsToprint;
    }

    public int getDeckSize(){
        return cards.size();
    }

    public int getCardValue(){
        int totalScore=0;

        for (Card card : cards) {
            if(card.getValue()==Value.TWO){
                totalScore+=2;
            }

            if(card.getValue()==Value.THREE){
                totalScore+=3;
            }

            if(card.getValue()==Value.FOUR){
                totalScore+=4;
            }

            if(card.getValue()==Value.FIVE){
                totalScore+=5;
            }

            if(card.getValue()==Value.SIX){
                totalScore+=6;
            }

            if(card.getValue()==Value.SEVEN){
                totalScore+=7;
            }

            if(card.getValue()==Value.EIGHT){
                totalScore+=8;
            }

            if(card.getValue()==Value.NINE){
                totalScore+=9;
            }

            if(card.getValue()==Value.TEN){
                totalScore+=10;
            }

            if(card.getValue()==Value.JACK){
                totalScore+=10;
            }

            if(card.getValue()==Value.QUEEN){
                totalScore+=10;
            }

            if(card.getValue()==Value.KING){
                totalScore+=10;
            }

            if(card.getValue()==Value.ACE){
                if(totalScore<=10){
                    totalScore+=11;
                }
                else{
                    totalScore+=1;
                }
            }

        }
        return totalScore;
    }
}
