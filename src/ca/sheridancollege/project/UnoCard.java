package ca.sheridancollege.project;

/**
 * This class extends the card class so that it can be used as a UNO cards.
 *
 * @author Moon Hyuk Kang, James Hong, Ellie Khuzam
 */
public class UnoCard extends Card{
        
    public UnoCard(Type type, Value value) {
        if (!value.equals(value.WILDCARD) && !value.equals(value.WILDFOUR)) {
            this.type = type;
        }
        this.value = value;
    }
    
    @Override
    public String toString() {
        if (value.equals(value.WILDCARD) || value.equals(value.WILDFOUR)) {
            if (type != null) {
                return value.toString() + " (" + type.toString()+")";
            }
            return value.toString();
        }
        return type.toString() + " " + value.toString();
    }
}
