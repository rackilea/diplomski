public void wash(Fruit f)
{
   if(f instanceof Apple)
   {
      wash((Apple) f) ;
   }
   else if(f instanceof Peach)
   {
      wash((Peach) f) ;
   }
   else
   {
      // handle the error, usually through an exception
   }
}