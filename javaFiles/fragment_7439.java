public class ScoredItem {
    public int itemId;
    public double score;

    public ScoredItem(int i, double s) {
        itemId = i;
        score = s;
    }

    public static void main(String[] args) {
        List<ScoredItem> items = new ArrayList<ScoredItem>();
        items.add(new ScoredItem(1,3.0));
        items.add(new ScoredItem(1,2.0));
        items.add(new ScoredItem(1,1.1));
        items.add(new ScoredItem(1,0.33));
        items.add(new ScoredItem(1,0.22));

        assertThat(items)
            .extracting("score")
            .usingComparatorForType(new DoubleComparator(0.2), Double.class)
            .containsSequence(3.0, 2.0, 1.0, 0.35, 0.2);

    }
}