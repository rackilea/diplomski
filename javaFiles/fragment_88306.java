import java.util.HashMap;
import java.util.Map;

public class HelloWorld {
     public static void main(String []args){
        Map<String, Integer> myMap = new HashMap<String, Integer>();

        String[] products = {"Apple", "Pear", "Banana", "Apple"};
        String[] amounts = {"2", "3", "3", "2"};

        for (int i = 0; i < products.length; i++) {
            String product = products[i];
            int amount = Integer.valueOf(amounts[i]);

            if (myMap.containsKey(product)) {
                myMap.put(product, myMap.get(product) + amount);
            } else {
                myMap.put(product, amount);
            }
        }

        for (String product : myMap.keySet()) {
            System.out.println(product + ": " + myMap.get(product));
        }
     }
}