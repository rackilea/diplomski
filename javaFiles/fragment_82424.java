package Tracker;
import java.util.ArrayList;


public class OutFaro {
private ArrayList<String> shuffleResults;
private int shuffleCounter;


public ArrayList<String> getOneShuffle() {
    return shuffleResults;
}

public ArrayList<String> outFaro(ArrayList<String> newDeckOrder, int numberOfFaros) {

    shuffleResults = new ArrayList<>();
    ArrayList<String> temp = new ArrayList<>();
    while (shuffleCounter != numberOfFaros) {

        for (int i = 0; i < newDeckOrder.size() - 26; i++) {
            for (int j = 26; j < newDeckOrder.size(); j++) {
                temp.add(newDeckOrder.get(i));
                temp.add(newDeckOrder.get(j));
                i++;
            }
        }

        shuffleCounter++;
        if (shuffleCounter == numberOfFaros) {
            shuffleResults = temp;
        } else {
            outFaro(temp, numberOfFaros);
        }

    }
    return shuffleResults;
}

@Override
public String toString() {
    return "OutFaro{" +
            "oneShuffle=" + shuffleResults +
            '}';
}
}