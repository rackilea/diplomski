class Example
{
    public static void main (String[] args) throws java.lang.Exception
    {
        new TeradataTable("foo");
    }
}

class RdbmsTable {
    public RdbmsTable(String uri) {
       System.out.println(this.getClass().getSimpleName().toUpperCase());
    } 

}

class TeradataTable extends RdbmsTable {
    public TeradataTable(String uri) {
        super(uri);
    }
}