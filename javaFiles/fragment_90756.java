public class CustomComparator implements Comparator<StudentList> {
    private final String sortBy;
    private final boolean ascending;

    public CustomComparator() {
        sortBy = COLUMN_LAST_NAME;
        ascending = true;
    }

    public CustomComparator(String sortBy, boolean ascending) {
        this.sortBy = sortBy;
        this.ascending = ascending;
    }
}