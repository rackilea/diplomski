import java.util.HashMap;
import java.util.Map;

public class Test{

    public static void main(String[] arguments) {

        //map category to sales values
        Map<String, int[]> salesMap = new HashMap<>();

        //map category to sales totals
        Map<String, Integer> totalSalesMap = new HashMap<>();

        int[] mac = {11500,9000,13000,900,100};//total 34500
        salesMap.put("Mac",mac);
        int[] iphone = {1100,5000,3400,0,0};//total $9500
        salesMap.put("Iphone",iphone);
        int[] ipad = {900,4300000,0,800,0};
        salesMap.put("Ipad",ipad);
        int[] ipod = {0,300,120,500,25000};
        salesMap.put("Ipod",ipod);

        totalSalesMap = totalSale(salesMap);

        //print totals:
        for( String category : totalSalesMap.keySet()){
            System.out.println("Total sale for category "
                            + category + ": $" + totalSalesMap.get(category));
        }
    }

    public static Map<String, Integer> totalSale(Map<String, int[]> salesMap){

        //returned map holding sales totals
        Map<String, Integer> totalSalesMap = new HashMap<>();

        //iterate over sales map and sum values into totalSalesMap
        for( String category : salesMap.keySet()){

            int[] sales = salesMap.get(category);
            int salesSum = sumArray(sales);

            //add total to returned map
            totalSalesMap.put(category, salesSum);
        }

        return totalSalesMap;
    }

    private static int sumArray(int[] array) {

        int sum = 0;
        for(int i : array) {
            sum += i;
        }

        return sum;
    }
}