import static java.util.Map.Entry;

public class CompareRank implements Comparator<Entry<OfficerRank, Integer>>{
  @Override
  public int compare(Entry<OfficerRank,Integer> arg0, Entry<OfficerRank,Integer> arg1) {
    int val1 = arg0.getValue();
    int val2 = arg1.getValue();
    return Integer.compare(val2,val1);
}