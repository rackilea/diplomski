class MyabsClass 
{
  abstract String orderDescription();
}

class MyImplementation extends MyabsClass
{
   public String orderDescription()
    {
    return "This is description";
    }
}



 class MyClient
   {
     public static void main(String[] args)
      {
         MyImplementation imple = new MyImplementation();
         imple.orderDescription();
      }
   }