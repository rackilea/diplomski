import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;


public class TestPriorityQueue 
{
  static Map<String,Double> codebook = new HashMap<String, Double>();
  static {
    codebook.put("need", 3.0);
    codebook.put("cat", 1.0);
    codebook.put("neat", 2.0);
  }

  public static void main(String[] args)
  {
    test();
  }

  public static void test() {
    PriorityQueue<Node> heap = new PriorityQueue<Node>();
    Set<String> allWords = codebook.keySet();
    for (String word : allWords) {
      heap.add(new Node(word, codebook.get(word)));
      System.out.println(heap.toString());
    }

    System.out.println("In order now:");
    while(!heap.isEmpty()) {
      System.out.println(heap.poll());
    }
  }

  private static class Node implements Comparable<Node>
  {
      protected Node left;
      protected Node right;
      protected String name;
      protected double frequency;
      public Node(String n, double f)
      {
          name = n;
          frequency = f;
      }
      public Node(double f, Node l, Node r)
      {
          frequency = f;
          left = l;
          right = r;
      }

      @Override
      public int compareTo(Node arg0) 
      {
          if(this.frequency < arg0.frequency)
          {
              System.out.println(name + " < " + arg0.name);
              return -1;
          }
          else if(this.frequency > arg0.frequency)
          {
              System.out.println(name + " > " + arg0.name);
              return 1;
          }
          System.out.println(name + " is equal to " + arg0.name);
          return 0;
      }

      public String toString()
      {return name;}
  }

}