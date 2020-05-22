try
{
     currency = (serviceCountry.createCurrencyTicket( cr, null ));
}catch(MyCustomException ex)
{
     if( ex.getStatus() == 2 )
         currency = "Oh Nos";
     else if( ex.getStatus() == 0 )
         currency = "Ehh";
}catch(Exception e)
{
     currency = "SuperBad";
}