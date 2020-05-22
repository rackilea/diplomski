import java.text.Collator;
import java.util.Comparator;
import java.util.LinkedList;

public class MyLinkedList extends LinkedList<Apartament> {
    public void sortByOrientare(){
        sort(new MyComparator());
    }
    class MyComparator extends Comparator<Apartament> {
        @Override
        public int compare(Apartament s1, Apartament s2){
            return Collator.getInstance().compare(s1.getOrientare(), s2.getOrientare());
        }
    }
}