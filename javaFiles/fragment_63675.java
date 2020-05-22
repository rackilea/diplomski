Connection connection = ConnectionFactory.createConnection(config);

Table table = connection.getTable(TableName.valueOf("table1"));

try 
{
   // Use the table as needed, for a single operation and a single thread
} 
finally
{
   table.close();
   connection.close();
}