public class Calculator{
    private final Object monitor = new Object();
    private Table table = new DefaultTable();

    public Result calculate() {
        synchronize (monitor) {
            // implementation
        }
    }

    public void setTable(Table newtable){
        synchronize (monitor) {
            this.table = newtable
        }
    }
}