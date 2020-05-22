import java.util.*;

public class Test
{
  public static void main(String[] args)
  {
    PriorityQueue<Map.Entry<String,Double>> queue = new PriorityQueue<>(10, new Comparator<Map.Entry<String, Double>>() {
      @Override
      public int compare(Map.Entry<String,Double> x, Map.Entry<String,Double> y)
      {
        if (x.getValue() < y.getValue())
        {
          return -1;
        }
        if (x.getValue() > y.getValue())
        {
          return 1;
        }
        return 0;
      }
    });

    HashMap<String,Double> balances = new HashMap<String,Double>();
    balances = Test.populateBalances(); // return the populated map

    for (Map.Entry<String, Double> entry : balances.entrySet()) {
      queue.add(entry);
      if (queue.size() > 10)
      queue.poll();
    }

    for (Map.Entry<String, Double> entry : queue)
      System.out.println(entry.getKey() + ":" + entry.getValue());
  }

  public static HashMap<String, Double> populateBalances() {
    HashMap<String,Double> balances = new HashMap<String,Double>();
    balances.put("test1", 1000.2);
    balances.put("test2", 200.3);
    balances.put("test3", 12000.2);
    balances.put("test4", 2050.3);
    balances.put("test5", 1034.2);
    balances.put("test6", 210.3);
    balances.put("test7", 10.2);
    balances.put("test8", 0.3);
    balances.put("test9", 13210.2);
    balances.put("test10", 2223.3);
    balances.put("test11", 101.2);
    balances.put("test12", 200.1);

    return balances;
  }

}