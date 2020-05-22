import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Test {
    private List<DailyIncome> shopA = new ArrayList<DailyIncome>();
    private List<DailyIncome> shopB = new ArrayList<DailyIncome>();
    private List<List<String>> shop = new ArrayList<List<String>>();
    public void initialize(){
        shopA.add(new DailyIncome("20-08-16", "4"));
        shopA.add(new DailyIncome("21-08-16", "8"));
        shopA.add(new DailyIncome("23-08-16", "3"));

        shopB.add(new DailyIncome("20-08-16", "6"));
        shopB.add(new DailyIncome("21-08-16", "7"));
        shopB.add(new DailyIncome("22-08-16", "8"));
    }
    public void calculate(){

        Map<String, String> mapA = new HashMap<String, String>();
        Map<String, String> mapB = new HashMap<String, String>();

        for(DailyIncome income: shopA){
            mapA.put(income.date, income.total);
        }

        for(DailyIncome income: shopB){
            mapB.put(income.date, income.total);
        }


        Set<String> keySet = new HashSet<String>();
        keySet.addAll(mapA.keySet());
        keySet.addAll(mapB.keySet());

        Object keyArr[] = keySet.toArray();

        for(int i = 0; i < keyArr.length; i++){
            String key = (String)keyArr[i];
            String totalA = mapA.containsKey(key) ? mapA.get(key):"0";
            String totalB = mapB.containsKey(key) ? mapB.get(key):"0";
            List<String> itemList = new ArrayList<String>();
            itemList.add(key);
            itemList.add(totalA);
            itemList.add(totalB);
            shop.add(itemList);
        }

        /*
         * print
         */
        for(List<String> itemList: shop){
            System.out.print(itemList.get(0) + "   ");
            System.out.print(itemList.get(1) + "   ");
            System.out.print(itemList.get(2));
            System.out.println();
        }
    }

    public static void main(String args[]){
        Test obj = new Test();
        obj.initialize();
        obj.calculate();
    }
}