/**
 * @author 
 *
 *   /\_/\  _     ___
 *  |>'v'<||"| -/\, ,`>
 *     -=Edelstein=-
 * 
 */
package basicencyrption.program;
import java.util.Scanner;

public class BasicEncyrptionProgram {
    public static void main(String[] args) {
        /* setting variables */
        Scanner inputInt = new Scanner(System.in);
        Scanner inputLine = new Scanner(System.in);
        
        int menuOption = 3;
        String toCrypt = null;
        
        
        /* Main menu */
        do{
            
            System.out.println("Welcome to the basic encryption program!");
            System.out.println("Please select an option from the list:");
            System.out.println("Note: The way that this encryption program works, all outputs will be lower case, and will likely only work with characters between a-z");
            System.out.println("[1] encrypt some text");
            System.out.println("[2] decrypt some data");
            System.out.println("[0] exit");

            menuOption = inputInt.nextInt();
            if(menuOption == 1 || menuOption == 2){
                System.out.println("Input data to encrypt or decrypt:");
                toCrypt = inputLine.nextLine();
            }
            
            
        } while(menuOption > 2);
        
        
        /* Filter */
        switch (menuOption) {
            case 1:
                toCrypt = toCrypt.toUpperCase();
                encryptText(toCrypt);
                break;
            case 2:
                decryptData(toCrypt);
                break;
            case 0:
                System.exit(0);
                break;
            default:
                System.out.println("Error: Invalid index");
                break;
        }
        
        
    }
    
    private static void encryptText(String input){
        /* setting variables */
        char[] encrypt = new char[input.length()];
        char tempChar;
        int tempAscii;
        String toOutput = "";
        
        /* main loop for encrypting each character */
        for (int i = 0; i < input.length(); i++) {
            /* setting 'encrypt' array */
            encrypt[i] = input.charAt(i);
            
            /* converting characters in 'encrypt' to ascii values */
            tempChar = (char)encrypt[i];
            tempAscii = (int)tempChar + 23; // + 23 for ceaser cipher esque 
            
            // sets the ascii value back to character, and adds to 'toOutput' String variable
            toOutput = toOutput + Character.toString((char)tempAscii);
        }
        
        // output 'toOutput'
        System.out.println(toOutput.toLowerCase());
        
    }
    
    private static void decryptData(String input){
        /* setting variabels */
        char[] decrypt = new char[input.length()];
        char[] decrypted = new char[input.length()];
        char tempChar;
        int tempAscii = 0;
        String toOutput = "";
        
        /* main decryption loop */
        for (int i = 0; i < input.length(); i++) {
            decrypt[i] = input.charAt(i);
            
            tempChar = (char)decrypt[i];
            tempAscii = (int)tempChar - 23; // the decryption algoritim is just the encryption one, but - 23 instead of + 23!
            
            decrypted[i] = (char)tempAscii;
            toOutput = toOutput + Character.toString(decrypted[i]);
            
        }
        
        System.out.println(toOutput.toLowerCase()); 
        
    }
}