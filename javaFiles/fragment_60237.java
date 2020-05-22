String getReadableLevel(int isolation)
{
String result="";

switch(isolation)
{
  case Connection.TRANSACTION_SERIALIZABLE: result="TRANSACTION_SERIALIZABLE";break;
  ...//u get the idea
}
return result;
}