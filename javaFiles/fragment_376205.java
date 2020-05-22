import java.util.*;

public class NGramExample{

    public static HashMap<String, Integer> ngrams(String text, int n) {
        ArrayList<String> words = new ArrayList<String>();
        for(String word : text.split(" ")) {
            words.add(word);
        }

        HashMap<String, Integer> map = new HashMap<String, Integer>();

        int c = words.size();
        for(int i = 0; i < c; i++) {
            if((i + n - 1) < c) {
                int stop = i + n;
                String ngramWords = words.get(i);

                for(int j = i + 1; j < stop; j++) {
                    ngramWords +=" "+ words.get(j);
                }
                map.merge(ngramWords, 1, Integer::sum);
            }
        }

        return map;
    }

     public static void main(String []args){
        System.out.println("Ngrams: ");
        HashMap<String, Integer> res = ngrams("Patient name xyz phone no 12345 emailid xyz@abc.com. Patient name abc address some us address", 2);
        for (Map.Entry<String, Integer> entry : res.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue().toString());
        }
     }
}