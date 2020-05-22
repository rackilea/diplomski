import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

public class HashMultimapTest {

    public static void main(String[] args) {
        Multimap<String,String> map = HashMultimap.create();

        map.put("question 2", "answer 2");
        map.put("question 1", "answer 1");
        map.put("question 3", "answer 3");
        map.put("question 1", "another answer 1");

        System.out.println(map);
        //{question 1=[answer 1, another answer 1], 
        // question 2=[answer 2], 
        //question 3=[answer 3]}
    }
}