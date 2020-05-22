@Component 
public class BinarySearch {

// Sort, Search, Return the result!
private final Sorter sorter;

public BinarySearch(@Qualifier("quick")Sorter sorter) {
    super();
    this.sorter = sorter;
}