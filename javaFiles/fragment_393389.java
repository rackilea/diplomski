public class Calculator{
    private Table table = new DefaultTable();

    public synchronized Result calculate(){
        // implementation
    }

    public synchronized void setTable(Table newtable){
        this.table = newtable
    }
}