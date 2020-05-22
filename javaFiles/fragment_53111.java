Try
{
   while (true) {
      try {
          // do something with in and out.
      } catch (IOException ex) {
         System.out.println(ex);
         break;
      } 
    }
} 
finally {
    for (int i=0; i < MyList.size(), i++)
       if (MyList.get(i) == this) 
       {
           MyList.delete(i);
           break;
       }
}