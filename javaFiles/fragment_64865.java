public boolean updateTable()
{

boolean isSuccessFul = false;
// Prepare the statements and the connections

try
{
// Execute the update

isSuccessFul = true;
}
catch(Exception e)
{
// Handle it
}
finally
{
 return isSuccessFul;
}
}