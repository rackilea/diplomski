import scala.Tuple2;
import java.io.Serializable;

class DummyComparator implements 
      Comparator<Tuple2<Integer, String>>, Serializable {
   public int compare(Tuple2<Integer, String> x, Tuple2<Integer, String> y) {
        return -1;
    }
}