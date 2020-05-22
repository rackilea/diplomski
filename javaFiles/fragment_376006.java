import org.apache.mahout.fpm.pfpgrowth.fpgrowth.*;

import java.io.IOException;
import java.util.*;

import org.apache.mahout.common.iterator.*;
import org.apache.mahout.fpm.pfpgrowth.convertors.*;
import org.apache.mahout.fpm.pfpgrowth.convertors.integer.*;
import org.apache.mahout.fpm.pfpgrowth.convertors.string.*;

import org.apache.hadoop.mapred.OutputCollector;
import org.apache.mahout.common.*;

import org.apache.hadoop.io.Text;

class FPGrowthDemo {

  public static void main(String[] args) {
    long minSupport = 1L;
    int k = 50;
    FPGrowth<String> fps = new FPGrowth<String>();

    String milk = "milk";
    String bread = "bread";
    String butter = "butter";
    String bier = "bier";

    LinkedList<Pair<List<String>, Long>> data = 
        new LinkedList<Pair<List<String>, Long>>();

    data.add(new Pair(Arrays.asList(milk, bread), 1L));
    data.add(new Pair(Arrays.asList(butter), 1L));
    data.add(new Pair(Arrays.asList(bier), 1L));
    data.add(new Pair(Arrays.asList(milk, bread, butter), 1L));
    data.add(new Pair(Arrays.asList(milk, bread, bier), 1L));
    data.add(new Pair(Arrays.asList(milk, bread), 1L));

    // This lines is removed...
    // Iterator<Pair<List<String>, Long>> transactions = data.iterator();

    Collection<Pair<String, Long>> frequencies = fps.generateFList(
        data.iterator(), // use an iterator here...
        (int) minSupport);

    System.out.println("freqList :" + frequencies);

    OutputCollector<String, List<Pair<List<String>, Long>>> output = 
        new OutputCollector<String, List<Pair<List<String>, Long>>>() {

      @Override
      public void collect(String x1, 
                          List<Pair<List<String>, Long>> listPair)
          throws IOException {
        StringBuffer sb = new StringBuffer();
        sb.append(x1 + ":");
        for (Pair<List<String>, Long> pair : listPair) {

          sb.append("[");
          String sep = "";
          for (String item : pair.getFirst()) {
            sb.append(item + sep);
            sep = ", ";
          }
          sb.append("]:" + pair.getSecond());
        }
        System.out.println("  " + sb.toString());
      }
    };

    StatusUpdater updater = new StatusUpdater() {
      public void update(String status) {
        System.out.println("updater :" + status);
      }
    };

    try {
      fps.generateTopKFrequentPatterns(
        // changed here (previously : transactions)
        data.iterator(), // use a "fresh" iterator
        frequencies, 
        minSupport, 
        k, 
        null, 
        output, 
        updater);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}