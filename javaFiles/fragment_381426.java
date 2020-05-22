import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class IntraArrayValuesComparison {
    private static boolean isInRange(Integer st, Integer val) {
        final int DELTA = 5;
        return val.intValue() >= (st.intValue() - DELTA) && val.intValue() <= (st.intValue() + DELTA);
    }

    private static List<Integer> getDeckWithLessCards(List<List<Integer> > resultDecks) {
        if(resultDecks.isEmpty())
            return new ArrayList<>();

        List<Integer> cards = resultDecks.get(0);
        for(int i= 1; i < resultDecks.size(); ++i) {
            if(resultDecks.get(i).size() < cards.size())
                cards = resultDecks.get(i);
        }
        return cards;
    }

    private static Collection<List<Integer> > sort(List<Integer> deck, Integer splitSize) {
        Map<Integer, List<Integer>> decks = new TreeMap<>();
        outerLoop:
        for(Integer card : deck) {
            List<Integer> cards = new ArrayList<>();
            Iterator<Integer> itr = decks.keySet().iterator();  
            while (itr.hasNext()) {
                Integer masterCard = itr.next(); 
                if(isInRange(card, masterCard)) {                   
                    decks.get(masterCard).add(card);
                    continue outerLoop;
                }
            }
            decks.put(card, cards);
            decks.get(card).add(card);
        }

        System.out.println("Arranged decks:\t" + decks.values());
        //do transpose
        List<List<Integer> > resultDecks = new ArrayList<>();
        if(splitSize == null || splitSize < 2)
            splitSize = decks.size();
        for(int i= 0; i < splitSize; ++i)
            resultDecks.add(new ArrayList<>());

        boolean lastCard = false;
        while(!decks.isEmpty()) {
            Iterator<Integer> itr = decks.keySet().iterator(); 
            if (itr.hasNext()) {
                Integer masterCard = itr.next(); 
                List<Integer> cards = decks.get(masterCard);
                Integer card = Collections.min(cards);
                cards.remove(card);
                boolean uno = cards.isEmpty();
                if(uno) {
                    lastCard = true;
                    getDeckWithLessCards(resultDecks).add(card);
                    itr.remove();
                }               
                else if(lastCard) {
                    resultDecks.get(0).add(card);
                    lastCard = false;
                }
                else
                    getDeckWithLessCards(resultDecks).add(card);
            }           
        }
        return resultDecks;
    }

    public static void main(String[] args) {
        String[] data = null;
        System.out.print("Please input data (1, 5, 10, 2, 15, 3, 20): ");
        try (Scanner scanner = new Scanner(System.in)) {
            data = scanner.nextLine().split(",");
        } catch(Exception ex) {
            System.out.println("\nIncorrect data format.");
            return;
        }

        if(data == null || data.length < 2) {
            System.out.println("Incorrect data format.");
            return;
        }

        List<Integer> deck = new ArrayList<>();  
        for(String value : data)
            deck.add(new Integer(value.trim()));

        Collection<List<Integer> > resultDecks = sort(deck, 3);
        System.out.println("Final decks:\t" + resultDecks);

        System.out.println();
    }

}