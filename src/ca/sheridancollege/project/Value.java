package ca.sheridancollege.project;

/**
 * This is the enum for value of the cards
 *
 * @author Moon Hyuk Kang, James Hong, Ellie Khuzam
 */
public enum Value {
    ZERO(0, 1),
    ONE(1, 2),
    TWO(2, 2),
    THREE(3, 2),
    FOUR(4, 2),
    FIVE(5, 2),
    SIX(6, 2),
    SEVEN(7, 2),
    EIGHT(8, 2),
    NINE(9, 2),
    SKIP(10, 2),
    REVERSE(11, 2),
    PLUSTWO(12, 2),
    WILDCARD(13,1),
    WILDFOUR(14,1);
    
    private final int intValue;
    private final int numCard;
    
    Value(int intValue, int numCard) {
        this.intValue = intValue;
        this.numCard = numCard;
    }
    
    public int toInt() {
        return intValue;
    }
    
    public int getNumCard() {
        return numCard;
    }
    
    public String toString() {
        switch(intValue) {
            case 10:
                return "Skip";
            case 11:
                return "Reverse";
            case 12:
                return "+2";
            case 13:
                return "Wild";
            case 14:
                return "Wild +4";
            default:
                return intValue + "";
        }
    }
}
