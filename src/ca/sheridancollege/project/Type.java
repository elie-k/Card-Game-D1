package ca.sheridancollege.project;

/**
 * This is the enum for suit of the cards
 *
 * @author Moon Hyuk Kang, James Hong, Ellie Khuzam
 */
public enum Type {
    RED("Red"),
    YELLOW("Yellow"),
    GREEN("Green"),
    BLUE("Blue");
    
    private final String stringValue;
    
    Type(String stringValue) {
        this.stringValue = stringValue;
    }
    
    public String toString() {
        return stringValue;
    }
}
