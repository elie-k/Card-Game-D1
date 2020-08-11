package ca.sheridancollege.project;

import java.util.Scanner;

/**
 * This class extends the game class so that users can play uno by instantiating
 *
 * @author Moon Hyuk Kang, James Hong, Ellie Khuzam
 */
public class UnoGame extends Game {
    
    public PlayerInput sc = PlayerInput.getInstance();
    
    private Deck UNODeck;
    private Player winner;
    private Card lastPlayed;
    private boolean clockwiseTurn = true;
    private int currentPlayer = 3;
    private boolean cardUsed = false;
    
    public static void main(String[] args) {        
        new UnoGame().play();
    }
    
    public UnoGame() {
        super("UNO");
        UNODeck = new Deck();
        UNODeck.shuffle();
    }

    @Override
    public void play() {
        boolean gameOver = false;
        
        System.out.println("Welcome to UNO you will be playing with 3 other cpus");
        System.out.println("Please enter your name: ");
        for (int i = 0; i < 4; i++) {
            System.out.print("Enter player " + (i+1) + "'s name: ");
            getPlayers().add(new HumanPlayer(sc.nextLine()));
        }
        
        for (Player player : getPlayers()) {
            newHand(player);
        }
        
        lastPlayed = UNODeck.draw();
        
        while (!gameOver) {            
            printBoard();
            advanceTurn();
            rule();
            System.out.println(getPlayers().get(currentPlayer).getName()+"'s turn");
            Card card = getPlayers().get(currentPlayer).play(lastPlayed);
            if (card == null) {
                getPlayers().get(currentPlayer).getPHand().addCard(UNODeck.draw());
            } else {
                lastPlayed = card;
                cardUsed = false;
            }
            if (getPlayers().get(currentPlayer).getPHand().getSize() == 0) {
                gameOver = true;
                winner = getPlayers().get(currentPlayer);
            }
        }
        
        declareWinner();
    }
    
    public void newHand(Player player) {
        for (int i = 0; i < 7; i++) {
            player.getPHand().addCard(UNODeck.draw());
        }
    }
    
    public void printBoard() {
        System.out.println("\nCurrently on the board: "+lastPlayed);
    }
    
    private void rule() {
        Player player = getPlayers().get(currentPlayer);
        if (!cardUsed) {
            if (lastPlayed.getValue().equals(Value.SKIP)) {
                System.out.println("Skipping " + player.getName() + "'s turn");
                advanceTurn();
            }
            else if (lastPlayed.getValue().equals(Value.REVERSE)) {
                clockwiseTurn = clockwiseTurn? false:true;
                advanceTurn();
                advanceTurn();
            }
            else if (lastPlayed.getValue().equals(Value.PLUSTWO)) {
                player.getPHand().addCard(UNODeck.draw());
                player.getPHand().addCard(UNODeck.draw());
                System.out.println("Adding two cards and skipping " + player.getName() + "'s turn");
                advanceTurn();
            }
            else if (lastPlayed.getValue().equals(Value.WILDFOUR)) {
                for (int i = 0; i < 4; i++) {
                    player.getPHand().addCard(UNODeck.draw());
                }
                System.out.println("Adding four cards and skipping " + player.getName() + "'s turn");
                advanceTurn();
            }
            cardUsed = true;
        } 
        
            
    }
    
    private void advanceTurn() {
        if (clockwiseTurn)
            currentPlayer = (currentPlayer + 1)%4;
        else {
            if (currentPlayer == 0)
                currentPlayer = 3;
            else
                currentPlayer--;
        }
    }

    @Override
    public void declareWinner() {
        System.out.println("The Winner is " + winner.getName() + "!");
    }
    

}
