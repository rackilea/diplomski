import javax.sql.rowset.*; 

public class Test {
    public static void main(String[] args) throws Exception {

        CachedRowSet crs = RowSetProvider.newFactory().createCachedRowSet();
    }
}