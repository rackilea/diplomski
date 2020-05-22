public class MyReverseEngineeringStrategy extends DelegatingReverseEngineeringStrategy {

   public MyReverseEngineeringStrategy(ReverseEngineeringStrategy delegate) {
       super(delegate);
   }

   @Override
   public void setSettings(ReverseEngineeringSettings settings) {
       super.setSettings(settings);
   }

   @Override
   public boolean excludeForeignKeyAsCollection(String keyname, 
    TableIdentifier fromTable, java.util.List fromColumns, 
    TableIdentifier referencedTable, java.util.List referencedColumns) {

    // TODO : Your work here
    if (keyname.equals("___") && 
        fromTable.getName().equals("___") && 
        fromColumns.contains("___") && 
        referencedTable.getName().equals("___") && 
        referencedColumns.contains("___")) {

        return true;
    }

    return false;
   }
}