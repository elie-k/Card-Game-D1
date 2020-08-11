package ca.sheridancollege.project;

import java.util.Scanner;

/**
 * This class takes a input from player. This class will continuously ask the user for the correct input until they do so.
 *
 * @author Moon Hyuk Kang
 */
public class PlayerInput {
    private static PlayerInput instance = null;
    private Scanner sc = null;
    
    private PlayerInput() {
        sc = new Scanner(System.in);
    }
    
    public static PlayerInput getInstance() {
        if (instance == null) {
            instance = new PlayerInput();
        }
        return instance;
    }
    
    public int nextInt() {
        while (true) {
            int i;
            try {
                i = Integer.parseInt(sc.nextLine());
                return i;
            } catch (Exception e) {
                System.out.println("Invalid choice, please enter a integer: ");
            }
        }
    }
    
    public String nextLine() {
        return sc.nextLine();
    }

}
