package ca.sheridancollege.project;

import java.util.ArrayList;

/**
 * This class extends the GroupOfCards so that it can be used as a player's card collection on their hand
 *
 * @author Moon Hyuk Kang, James Hong, Ellie Khuzam
 */
public class PlayerHand extends GroupOfCards {
    
    public PlayerHand() {
        super(0);
    }
    
    public Card getCardIndex(int i) {        
        return this.cards.get(i);
    }
    
    public Card playCardIndex(int i) {
        
        Card card = this.cards.get(i);
        this.cards.remove(i);
        this.size--;
        
        return card;
    }
    
    public Card playCard(Card card) {
        
        this.cards.remove(card);
        this.size--;
        
        return card;
    }
    
    public boolean checkAvailable(Type type) {
        for (Card card : cards) {
            if (card.getType().equals(type)) {
                return true;
            }
        }
        return false;
    }
    
    public boolean checkAvailable(Value value) {
        for (Card card : cards) {
            if (card.getValue().equals(value)) {
                return true;
            }
        }
        return false;
    }
    
    public boolean checkAvailable(Type type, Value value) {
        for (Card card : cards) {
            if (card.getType().equals(type) || card.getValue().equals(value)) {
                return true;
            }
        }
        return false;
    }
    
    public ArrayList<Card> getPlayable(Type type, Value value) {
        ArrayList<Card> playables = new ArrayList<Card>();
        for (Card card : cards) {
            if (card.getValue().equals(Value.WILDCARD) || card.getValue().equals(Value.WILDFOUR)) {
                playables.add(card);
            } else if (card.getType().equals(type) || card.getValue().equals(value)) {
                playables.add(card);
            }
        }
        return playables;
    }
    
    @Override
    public String toString() {
        return cards.toString();
    }
}
