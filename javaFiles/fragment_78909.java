public static double calculateTotal (  )
  {
   double price;

   if ( cakeChoice <5 ) // use the class level variable cakeChoice
   {
   price = 88*quantity; // use the class level quantitiy
   } 
   else
   {
   price=130*quantity;
   }
 double totalPrice=0;
  totalPrice += price;
  return totalPrice;

  }//calculateTotal
  }//class