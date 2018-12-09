package com.company;
import java.util.Scanner;
import java.util.Random;

public class Main {

    public static void main(String[] args)
    {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        String plainText, encryptedText, decryptedText;

        System.out.print("Enter message: ");
        plainText = sc.nextLine();

        System.out.println();
        System.out.println("Encrypted message");
        encryptedText = EncryptMessage(plainText);
        System.out.println(encryptedText);
        System.out.println();

        System.out.println("Decrypted message:");
        decryptedText = DecryptMessage(encryptedText);
        System.out.println(decryptedText);
    }

    // This function takes a character and returns it as an encrypted 4-character string
    public static String EncryptCharacter(char character)
    {
        //Init Random
        Random r = new Random();
        //Init StringBuilder
        StringBuilder sb = new StringBuilder();

        //Convert character to hex value
        sb.append(Integer.toHexString(character));

        //Generate random character A-Z to insert in between.
        char c1 = (char)(r.nextInt(26) + 'A');
        char c2 = (char)(r.nextInt(26) + 'A');

        //Inserts the 2 chars between the number using offsets
        sb.insert(1,c1);
        sb.insert(3,c2);

        //return StringBuilder value as string
        return sb.toString();
    }

    // This function takes an encrypted character string and returns a decrypted character
    public static char DecryptCharacter(String encryptedCharacter)
    {
        //Create a new StringBuilder 'sb'
        StringBuilder sb = new StringBuilder();

        //Add our 'encryptedCharacter' e.g. '5V7G'
        sb.append(encryptedCharacter);

        //Delete character at index '1' e.g. '57G'
        sb.deleteCharAt(1);

        //Delete character at index '2' e.g. '57'
        sb.deleteCharAt(2);

        //Converts StringBuilder value '57' (as a hex value) back to an integer.
        //Finally, then the integer is cast as a char.
        char output = (char)Integer.parseInt(sb.toString(),16);
        return output;
    }

    // This function takes a plaintext message and returns the message as an encrypted string.
    public static String EncryptMessage(String plainText)
    {
        //Create a StringBuilder to create our output
        StringBuilder sb = new StringBuilder();

        //For each character in the message
        for (char c : plainText.toCharArray()) {

            //Encrypts the character and appends it to our string builder.
            sb.append(EncryptCharacter(c));
        }
        return sb.toString();
    }

    // This function takes an encrypted message and returns it as a decrypted message.
    public static String DecryptMessage(String encryptedText)
    {
        // You need to implement this function
        StringBuilder sb = new StringBuilder();

        // Loop for every 4 characters inside 'encryptedText'
        for(int i = 0; i < encryptedText.length(); i+=4) {
            //Get 4 character string from 'encryptedText' and save as 'temp'
            String temp = encryptedText.substring(i,i+4);
            //Add the result of DecryptCharacter to our StringBuilder value
            sb.append(DecryptCharacter(temp));
        }

        // Returns the string value of our StringBuilder
        return sb.toString();
    }
}
