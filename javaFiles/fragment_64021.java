import java.util.*;

class VoteComparator implements Comparator<String> {
    final Map<String, Integer> tally;
    VoteComparator(Map<String, Integer> tally) {
        this.tally = tally;
    }
    @Override public int compare(String pub1, String pub2) {
        int v1 = tally.get(pub1);
        int v2 = tally.get(pub2);
        return
           (v1 < v2) ? -1 :
           (v1 > v2) ? +1 :
           0;
    }           
};