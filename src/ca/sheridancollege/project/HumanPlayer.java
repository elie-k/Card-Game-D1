package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class extends the Player class to be suited for UNO
 *
 * @author Moon Hyuk Kang, James Hong, Ellie Khuzam
 */
public class HumanPlayer extends Player {
    
    private PlayerInput sc = PlayerInput.getInstance();
    
    public HumanPlayer(String name) {
        super(name);
    }

    @Override
    public Card play(Card card) {
        boolean turnOver = false;
        while (!turnOver) {
            System.out.println("\n" + getPHand().toString() + " " + this.getPHand().getSize() + " cards");
            System.out.println("What would you like to do?");
            System.out.println("1. Play a card");
            System.out.println("2. Draw a card");
            if (getPHand().getSize() == 2)
                System.out.println("3. Call UNO!");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            switch(choice) {
                case 1:
                    return chooseCardToPlay(card);
                case 2:
                    System.out.println("You drew a card");
                    return null;
                case 3:
                    if (getPHand().getSize() != 2)
                        System.out.println("Invalid choice");
                    else 
                        System.out.println("UNO!");
                    return chooseCardToPlay(card);
                default:
                    System.out.println("Invalid choice");
            }
        }
        return null;
    }
    
    private Card getPlayable(Card card) {
        
        for (int i = 0; i < getPHand().getPlayable(card.getType(), card.getValue()).size(); i++) {
            System.out.println(i + ". " + getPHand().getPlayable(card.getType(), card.getValue()).get(i));
        }
        
        if (getPHand().getPlayable(card.getType(), card.getValue()).size() == 0) {
            return null;
        }
        
        System.out.print("Which one of these cards do you want to play?: ");
        int choice = sc.nextInt();
        
        return getPHand().getPlayable(card.getType(), card.getValue()).get(choice);
    }
    
    private Card chooseCardToPlay(Card card) {
        Card playingCard = getPlayable(card);
        if (playingCard == null) {
            System.out.println("No available card, drawing card");
            return null;
        }
        getPHand().playCard(playingCard);
        if (playingCard.getValue().equals(Value.WILDCARD) || playingCard.getValue().equals(Value.WILDFOUR)) {
            System.out.println("Choose a color");
            for (int i = 0; i < Type.values().length; i++) {
                System.out.println(i + ". " + Type.values()[i].toString());
            }
            int colorChoice = sc.nextInt();
            playingCard.setType(Type.values()[colorChoice]);
        }
        if (this.getPHand().getSize() == 2) {
            System.out.println("You forgot to call UNO! Drawing two cards");
            this.getPHand().addCard(new UnoCard(Type.values()[(int) Math.random()*Type.values().length], Value.values()[(int) Math.random()*Value.values().length]));
            this.getPHand().addCard(new UnoCard(Type.values()[(int) Math.random()*Type.values().length], Value.values()[(int) Math.random()*Value.values().length]));
        }
        return playingCard;
    }
    
}
