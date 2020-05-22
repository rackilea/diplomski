public void setAge(String a)
{
  try
  {
    this.age = Integer.parseInt(a);
  }
  catch(NumberFormatException e){
    //.. code
  }
}