public class Table {
    private Hashtable<String, Integer> table = new Hashtable<>();

    public Table(Hashtable<String, Integer> table) {
        this.table = table;
    }

    public Table() {

    }

    public Hashtable<String, Integer> getTable() {
        return table;
    }

    public void setTable(Hashtable<String, Integer> table) {
        this.table = table;
    }

}