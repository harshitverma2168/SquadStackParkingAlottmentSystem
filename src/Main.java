import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * starting point of the program
 */
public class Main {
    public static void main(String args[]){
        {
            try {
                File file = new File("/home/harshitv-l/Documents/Automatic Parking System/input.txt");
                Scanner sc = new Scanner(file);
                while (sc.hasNextLine()) {
                    String str = sc.nextLine();
                    AllotmentSystem.processDetails(str);
                }
            } catch (FileNotFoundException ex) {
                System.out.println(ex);
            }
        }
    }
}
