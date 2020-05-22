import scala.collection.generic.Addable;
import scala.collection.generic.Subtractable;
import scala.collection.immutable.HashSet;
import scala.collection.immutable.Set;

public class Test {
    public static void main(String[] args) {
        Set s = new HashSet<String>();
        s = (Set<String>) ((Addable) s).$plus("GAH!");
        s = (Set<String>) ((Addable) s).$plus("YIKES!");
        s = (Set<String>) ((Subtractable) s).$minus("GAH!");
        System.out.println(s); // prints Set(YIKES!)
    }
}