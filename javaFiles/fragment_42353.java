import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class App {
    public App() {
        Map<Integer, Integer> map = buildMap();
        printFrequency(map);
    }

    public Map<Integer, Integer> buildMap() {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        Scanner input = new Scanner(System.in);
        int n, key;

        System.out.print("How many numbers will you enter?: ");
        n = input.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.printf("Enter integer #%d: ", i + 1);
            key = input.nextInt();
            map.put(key, map.containsKey(key) ? map.get(key) + 1 : 1);
        }

        input.close();

        return map;
    }

    public void printFrequency(Map<Integer, Integer> map) {
        Map<Integer, Integer> treeMap = new TreeMap<Integer, Integer>(map);

        System.out.println("\nValue\tFrequency");

        for (Integer key : treeMap.keySet()) {
            System.out.printf("%5d\t%9d\n", key, treeMap.get(key));
        }
    }

    public static void main(String[] args) {
        new App();
    }
}