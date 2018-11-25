package CardsGame;

import java.util.Scanner;

public class Main {
    private final static int WIN_SCORE=21;
    public static void main(String[] args) {

        Deck tableDeck=new Deck();
        tableDeck.makeDeck();
        tableDeck.shuffleDeck();
        Deck playerDeck=new Deck();
        Deck dealerDeck=new Deck();

        playerDeck.drawCardFromDeck(tableDeck);
        playerDeck.drawCardFromDeck(tableDeck);
        dealerDeck.drawCardFromDeck(tableDeck);
        dealerDeck.drawCardFromDeck(tableDeck);

        boolean playingGame=true;

        Scanner scanner = new Scanner(System.in);

        while(playingGame) {
            System.out.println("Your hand: " + playerDeck.toString());
            System.out.println("Your score: " + playerDeck.getCardValue());
            if(playerDeck.getCardValue()==WIN_SCORE){
                playerDeck.ifPlayerWins(dealerDeck,playerDeck);
            }
            System.out.println("Press 1 to play, press 2 to pass");
            int playOrnot = scanner.nextInt();
            if (playOrnot == 1) {
                playerDeck.drawCardFromDeck(tableDeck);
                System.out.println("Your new card is: " + playerDeck.getCard(playerDeck.getDeckSize()-1));
                if (playerDeck.getCardValue() > WIN_SCORE) {
                    dealerDeck.ifDealerWins(dealerDeck,playerDeck);
                    playingGame=false;
                    break;
                }
            } else if (playOrnot == 2) {
                break;
            }else{
                System.out.println("You've entered wrong value, to choose play or pass please enter 1 or 2");
            }
        }
        if(playingGame && dealerDeck.getCardValue()<WIN_SCORE && dealerDeck.getCardValue()<playerDeck.getCardValue()){
            dealerDeck.drawCardFromDeck(tableDeck);
        }
        if(playingGame && playerDeck.getCardValue()<dealerDeck.getCardValue() && dealerDeck.getCardValue()<=WIN_SCORE){
             dealerDeck.ifDealerWins(dealerDeck,playerDeck);
        }
        if(playingGame && dealerDeck.getCardValue()==WIN_SCORE ){
             dealerDeck.ifDealerWins(dealerDeck,playerDeck);
        }
        if(playingGame && playerDeck.getCardValue()>WIN_SCORE ){
            dealerDeck.ifDealerWins(dealerDeck,playerDeck);
        }
        if(playingGame && playerDeck.getCardValue()>dealerDeck.getCardValue() && playerDeck.getCardValue()<=WIN_SCORE){
            playerDeck.ifPlayerWins(dealerDeck,playerDeck);
        }
        if(playingGame && playerDeck.getCardValue()==WIN_SCORE){
            playerDeck.ifPlayerWins(dealerDeck,playerDeck);
        }
        if(playingGame && dealerDeck.getCardValue()>WIN_SCORE){
            playerDeck.ifPlayerWins(dealerDeck,playerDeck);
        }
        if(playingGame && dealerDeck.getCardValue()==playerDeck.getCardValue()){
            System.out.println("Yours and dealers scores are same. Play one more time");
        }
        }
    }

