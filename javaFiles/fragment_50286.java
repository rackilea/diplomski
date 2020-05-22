import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JOptionPane;


public class LetterCounter {

    //Hash maps don't allow duplication. 
    //The letter will be the Key and the repetitions the value(Your goal!)
    private Map<Character, Integer> resultsMap = new HashMap<Character, Integer>(); 

    public static void main(String[] args) {

        LetterCounter letterCounter = new LetterCounter();
        letterCounter.fillMap();
        letterCounter.showMapContents();        
    }

    private void showMapContents() {
        for (Entry<Character, Integer> entry : resultsMap.entrySet())
        {
            System.out.println("'" + entry.getKey() + "' - " + entry.getValue() + " times");
        }       
    }

    private void fillMap() {
        char[] userInputAsArray = getUserInputAsLetterArray();
        for (int currentLetter = 0; currentLetter < userInputAsArray.length; currentLetter++) {
            int count = getOccurences(userInputAsArray[currentLetter],userInputAsArray);
            resultsMap.put(userInputAsArray[currentLetter], count);
        }
    }

    private int getOccurences(int letter, char[] userInputAsArray) {
        int counter = 0;
        for (int currentIndex = 0; currentIndex < userInputAsArray.length; currentIndex++) {
            if(userInputAsArray[currentIndex] == letter)
                counter++;
        }
        return counter;
    }

    public char[] getUserInputAsLetterArray() {
        String userInput = JOptionPane.showInputDialog("Enter line of text:  ");
        char[] chars = userInput.toCharArray();
        return chars;
    }
}