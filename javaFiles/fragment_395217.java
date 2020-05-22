import java.util.ArrayList;
import java.util.HashMap;


public class Test {


    public static void main (String[] args){

        final ArrayList<HashMap<String, Integer>> listOne = new ArrayList<HashMap<String, Integer>>();
        final ArrayList<HashMap<String, Integer>> listTwo = new ArrayList<HashMap<String, Integer>>();

        // Test data for listOne
        for (int i = 0; i< 10; i++) {
            final HashMap<String, Integer> map = new HashMap<String, Integer>();

            map.put(String.valueOf(i), i);

            listOne.add(map);
        }

        // Test data for listTwo
        for (int i = 0; i< 20; i++) {
            final HashMap<String, Integer> map = new HashMap<String, Integer>();

            map.put(String.valueOf(i), i);

            listTwo.add(map);
        }

        // Determine the lower size
        final ArrayList<HashMap<String, Integer>> finalList = new ArrayList<HashMap<String, Integer>>();
        final int minSize = (listOne.size() <= listTwo.size()) ? listOne.size() : listTwo.size();

        // Iterate the two list with the lower size
        for (int i = 0; i<minSize; i++) {
            finalList.add(listOne.get(i));
            finalList.add(listTwo.get(i));
        }

        // Add the remanent for the bigger list if needed
        if (listOne.size() > minSize) {

            for (int i = minSize; i<listOne.size(); i++) {
                finalList.add(listOne.get(i));
            }

        } else if (listTwo.size() > minSize) {

            for (int i = minSize; i<listTwo.size(); i++) {
                finalList.add(listTwo.get(i));
            }
        }

        System.out.println(finalList);

    }
}