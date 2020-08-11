package ca.sheridancollege.project;

/**
 * This class +++Insert Description Here+++
 *
 * @author Moon Hyuk Kang
 */
public class Deck extends GroupOfCards {
    
    public Deck() {
        super(0);
        for (Type type : Type.values()) {
            for (Value value : Value.values()) {
                for (int i = 0; i < value.getNumCard(); i++) {
                    addCard(new UnoCard(type, value));
                }
            }
        }
    }
    
    public Card draw() {
        Card card = cards.get(0);
        cards.remove(0);
        this.size--;
        return card;
    }
    
}
