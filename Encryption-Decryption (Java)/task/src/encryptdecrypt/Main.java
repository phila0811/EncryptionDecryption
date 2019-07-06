package encryptdecrypt;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

            String operation = null;
            String word= null;
            int num = 0;
            File inputFile = null;
            File outputFile = null;

            for(int i = 0; i < args.length; i++){
                if (i % 2 == 0){
                    switch(args[i]){
                        case "-mode":
                            operation = args[i+1];
                            break;
                        case "-key":
                            num = Integer.parseInt(args[i+1]);
                            break;
                        case "-data":
                            word = args[i+1];
                            break;
                        case "-in":
                            inputFile = new File(args[i+1]);
                            break;
                        case "-out":
                            outputFile = new File(args[i+1]);
                            break;
                    }
                }
            }


            if(word != null) {
                if (operation.equals("enc")) {
                    String encryptedWord = encrypt(word, num);
                    System.out.println(encryptedWord);
                } else if (operation.equals("dec")) {
                    String decryptedWord = decrypt(word, num);
                    System.out.println(decryptedWord);
                }
            }else{
                System.out.println("word is null which is good");
                word = "";
                try{

                    Scanner scanner = new Scanner(inputFile);
                    FileWriter writer = new FileWriter(outputFile);
                    while(scanner.hasNext()){
                        word += scanner.nextLine();
                    }
                    System.out.println(word +": after reading from file.");
                    if(operation.equals("enc")) {
                        String encryptedWord = encrypt(word, num);

                        System.out.println("Encrypted word: " + encryptedWord);
                        writer.write(encryptedWord);

                        writer.close();
                        scanner.close();
                    }else if(operation.equals("dec")){
                        String decpryptedWord = decrypt(word, num);
                        writer.write(decpryptedWord);

                        writer.close();
                        scanner.close();
                    }

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }





    }

    public static String encrypt(String word, int num){
        StringBuilder sb = new StringBuilder();
        char[] wordArray = word.toCharArray();
        for(int i = 0; i < wordArray.length; i++){

                int placeholder = (int) wordArray[i]; //'a' == 97
                placeholder += num; // 97 + 5 == 102;
                char newChar = (char) placeholder; //f
                sb.append(newChar);

        }
        return sb.toString();
    }


    public static String decrypt(String word, int num){
        StringBuilder sb = new StringBuilder();
        num *= -1;
        char[] wordArray = word.toCharArray();
        for(int i = 0; i < wordArray.length; i++){

                int placeholder = (int) wordArray[i]; //'a' == 97
                placeholder += num; // 97 + 5 == 102;


                char newChar = (char) placeholder; //f
                sb.append(newChar);

        }
        return sb.toString();
    }
}
