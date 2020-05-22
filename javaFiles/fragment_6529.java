import java.util.StringTokenizer;

public class Entry implements Comparable<Entry> {

    private String qb;
    private String number;
    private String name;

    public Entry(String text) {
        StringTokenizer st = new StringTokenizer("", " ");
        this.qb = st.nextToken();
        this.number = st.nextToken();
        this.name = st.nextToken();
        // ... etc
    }

    @Override
    public int compareTo(Entry other) {
        return this.name.compareTo(other.name);
    }
}