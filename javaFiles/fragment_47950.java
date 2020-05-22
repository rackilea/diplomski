public void addProduct(String n, String p)
{
   // loop though the Customers
   for (Customer c : customerList)
   {
      // look for the one. i do not know what n is, assumed name from paramter n
      if (n.equals(c.getName()))
      {
         // when found:

         // add product to the wishlist, checking it is not on the list already
         if (!c.getWishlist().contains(p))
            c.getWishlist().add(p);
         // if adding order of the wishlist is not important, another collection type
         // EG a Set, which can only hold a value once, might be useful... 

         // exit the method, without throwing exception
         return;
      }
   }
   // if the loop finished, no Customer was found, throw exception
   throw new IllegalArgumentException();
}