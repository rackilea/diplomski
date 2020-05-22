import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;
public class Histogram {
    public static void main(String[] args) {
        Map<Integer,Integer> data = new HashMap<Integer,Integer>();
        data.put(10, 2);
        data.put(20, 3);
        data.put(30, 5);
        data.put(40, 15);
        data.put(50, 4);
        drawHistogram(data);
    }

    private static void drawHistogram(Map<Integer,Integer> data){
        SortedSet<Integer> keys = new TreeSet<Integer>(data.keySet());
        for(Integer key : keys){
            System.out.print(key + " : ");
            for(int i = 0; i< data.get(key); i++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}