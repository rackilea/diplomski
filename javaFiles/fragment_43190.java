import java.util.*;

public class ListCharIndexes {
    public static void main(String[] args) {
        List<String> letter = Arrays.asList("a","b","a","c","d","b","a");
       //letter= Arrays.asList("a","b","c","b","a");
        List<List<Integer>> result=new ArrayList<>();
        Set<String> result1=new HashSet<>();
        for (int i = 0; i < letter.size(); i++) {
            if(result1.add(letter.get(i))){ //skip String if it is already processed
                List<Integer> indexes=indexOfAll(letter.get(i), letter);
                if(indexes.size()>1)     //add only pairs
                    result.add(indexes);
            }
        }
        System.out.println(result);
    }
    static List<Integer> indexOfAll(String obj, List<String> list) {
        final List<Integer> indexList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++)
            if (obj.equals(list.get(i))) 
                indexList.add(i);
        return indexList;
    }
}