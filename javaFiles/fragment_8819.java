public abstract class ComparablePerson extends IDValueItem implements Comparable<ComparablePerson> {

    private int score;
    private String itemID,itemName;

    //setters and getters

    public int compareTo(ComparablePerson another) {
    if (score == another.getScore())
        return this.getItemName().compareToIgnoreCase(another.getItemName());
    else if ((score) > another.getScore())
        return 1;
    else
        return -1;
    }

    @Override
    public boolean equals(Object o) {
        return compareTo(o) == 0; 
    }   
}