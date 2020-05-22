import java.util.Comparator;

public class Sort implements Comparator<Equipment> { //Implementing a comparison tool for lists
    @Override
    public int compare(Equipment o1, Equipment o2) { //I want to compare one list to another - Update from Java 8
        return Double.compare(o2.getRoi(), o1.getRoi());
    }
}