package encryptdecrypt;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GetNumberFromFile {

    public static void main(String[] args) {
        File file = new File("numbers3.txt");
        int max = 0;
        int temp = 0;
        try {
            Scanner scanner = new Scanner(file);
            while(scanner.hasNext()){
                temp = Integer.parseInt(scanner.nextLine());
                if(temp == 0){
                    break;
                }

                if(temp % 2 == 0){
                    //System.out.println(temp);
                    max++;
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(max);


    }
}
