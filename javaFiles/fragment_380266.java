public class FruitAndCount implements Comparable<FruitAndCount> {
    private final String name;
    private final Integer count;

    public FruitAndCount(String name, int count) {
        this.name = name;
        this.count = count;
    }

    public String name() { return name;  }
    public int count()   { return count; }

    public int compareTo(FruitAndCount o) {
        return this.count.compareTo(o.count);
    }
}