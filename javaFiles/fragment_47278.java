A a = null;
try
{
  a = new A();
  //do stuff
}
finally
{
  a.Close();
}