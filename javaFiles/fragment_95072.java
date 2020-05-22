public class ItemComparator implements Comparator<Item>{
    public enum Field {
        ID, TIMESTAMP;
    }

    private Field field;

    public ItemComparator(Field field) {
        this.field = field;
    }