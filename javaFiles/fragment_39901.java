PreparedStatement pst;
...
if (pst instanceof DB2PreparedStatement) 
{
  int row_count = ((DB2PreparedStatement) pst).getEstimateRowCount();
  ...
}