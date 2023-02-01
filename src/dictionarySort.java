import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class dictionarySort {

    Scanner sc;

    {
        try {
            sc = new Scanner(new File("src/dictionary.txt"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    Scanner sc2;

    {
        try {
            sc2 = new Scanner(new File("src/sample.txt"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    boolean checking = true;
    boolean finding = true;
    boolean wordFound = false;

    public void wordCheck() { // Method that compares words found in sample.txt to words in dictionary.txt

        ArrayList<String> errors = new ArrayList<String>();
        String word = ""; // Empty string to hold word while being checked
        String dictionaryWord = "";

        while (checking) {


            if (sc2.hasNext() != true) { // Using hasNext method from the scanner class to check if there is still words left to be checked iun sample.txt, if not checking becomes false
                checking = false;
            }

            word = sc2.next();


            while (finding) {

                if (sc.hasNext() != true) { // Using hasNext method from the scanner class to check if there is still words left to be checked iun sample.txt, if not checking becomes false
                    finding = false;
                }

                if(sc.hasNextLine() == true){
                    dictionaryWord = sc.nextLine();
                }
                if (word.equals(dictionaryWord)) {
                    wordFound = true;
                }
            }

            if (wordFound == true) { // We found the word in the dictionary so it's not an error, so reset wordFound to false, so we can check the next word.
                wordFound = false;
            } else { // If wordFound remains false then we add the word to our list of errors
                errors.add(word); //
            }
        }

        for (int k = 0; k < errors.size(); k++) { // Prints out all the errors found in the paragraph.
            System.out.println(errors.get(k));
        }
    }
}