try
{
 //code of operation
}
catch(Exception error)
{ //code to handle exception
  error.printStackTrace();
}
finally
{ //any code which need to execute mandatory   
  commit();
  db.close();
}