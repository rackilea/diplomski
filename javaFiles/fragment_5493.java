try
{
     currency = (serviceCountry.createCurrencyTicket( cr, null ));
}catch(Exception e)
{
     if( e instanceof MyCustomException )
     {
         MyCustomException customEx = (MyCustomException)e;
         if( customEx.getStatus() == 2 )
             currency = "Oh Nos";
         else if( customEx.getStatus() == 0 )
             currency = "Ehh";
     }
     else
         currency = "SuperBad";
}