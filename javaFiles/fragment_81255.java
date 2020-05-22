import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.Map.Entry;
import java.util.LinkedHashMap;
import java.util.Iterator;

public class SumSet {
    static Map<Integer, ArrayList<Integer>> handleAllSumPossibilities(ArrayList<Integer> itemList, int balance, ArrayList<Integer> combination, Map<Integer, ArrayList<Integer>> qualifyItemsCombination) {

        System.out.println("COMBINATION FOR TEST: "+combination);

       int sum = 0; 
       Integer remain=null; 


       for (int x: combination){ sum += x;}; 

       if (sum <= balance && sum != 0){
            remain=(balance - sum);

            qualifyItemsCombination.put(remain,combination);
            System.out.println("ADD COMBINATION TO MAP: "+combination+"  CURRENT QUALIFIED COMBINATION: "+qualifyItemsCombination);
       }else{
            System.out.println("IGNORE COMBINATION: "+combination+"  NOT QUALIFY, THE COMBINATION IS EXCEEDED THE BALANCE");
       }
            System.out.println("_____________________________");


       for(int i=0;i<itemList.size();i++) {
             ArrayList<Integer> remainingItems = new ArrayList<Integer>();

             int pointingItem = itemList.get(i); 
             for (int j=i+1; j<itemList.size();j++) remainingItems.add(itemList.get(j));

             ArrayList<Integer> combinationRecord = new ArrayList<Integer>(combination);

             combinationRecord.add(pointingItem);

             Map<Integer, ArrayList<Integer>> retrievedItemsCombination = handleAllSumPossibilities( remainingItems, balance, combinationRecord, qualifyItemsCombination);
             qualifyItemsCombination = retrievedItemsCombination;

       }
            return qualifyItemsCombination;
    }



    static Map<Integer, ArrayList<Integer>> findBestCombination(ArrayList<Integer> itemList, int balance) {

        Map<Integer, ArrayList<Integer>> qualifyItemsCombination;
        qualifyItemsCombination = handleAllSumPossibilities(itemList,balance,new ArrayList<Integer>(),new HashMap<>());

        System.out.println("THE FINAL QUALIFIED COMBINATION: "+qualifyItemsCombination);

        //sort the key (remaining balance)
        List<Entry< Integer, ArrayList<Integer>>> qualifyItemsCombinationList = new ArrayList<>(qualifyItemsCombination.entrySet());
        qualifyItemsCombinationList.sort(Entry.comparingByKey());

        //place the sort result
        Map<Integer, ArrayList<Integer>> sortedResult = new LinkedHashMap<>();
        for (Entry<Integer, ArrayList<Integer>> entry : qualifyItemsCombinationList) {
            sortedResult.put(entry.getKey(), entry.getValue());
        }
        System.out.println("QUALIFIED COMBINATION AFTER SORTED: "+sortedResult);

        //iterate to get the first combination = the combination with lesser remaining.
        Map.Entry<Integer, ArrayList<Integer>> entry = sortedResult.entrySet().iterator().next();
        Integer getMapKey = entry.getKey();
        ArrayList<Integer> getMapValue=entry.getValue();

        //remove all the combination that contains the remaining(key)
        //different to the lesser remaining
        //the reason of doing this is to filter the combinations and ensure the map only left the combinations with the lesser remaining
        //since it might contains more than one combination are having the lesser remaining
        sortedResult.entrySet().removeIf(key -> key.getKey() != getMapKey);
        System.out.println("THE COMBINATION WITH LESSER BALANCE: "+sortedResult);

        return sortedResult;
    }



    public static void main(String args[]) {
        ArrayList<Integer> itemList = new ArrayList<>();
        itemList.add(450);
        itemList.add(350);
        itemList.add(300);
        itemList.add(200);

        int balance = 900;

        Map<Integer, ArrayList<Integer>> returnResult;
        returnResult = findBestCombination(itemList,balance);

        //Iterate to display all the combination with lesser balance remaining
        Iterator it = returnResult.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            System.out.println("THE LESSER REMAINING: "+pair.getKey() + ", THE COMBINATION TO ACHIVE THIS: " + pair.getValue());   
            it.remove(); // avoid concurrent modification exception
        }
    }
}