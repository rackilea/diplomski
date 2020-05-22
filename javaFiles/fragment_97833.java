public String getFormattedValue(double value)
{

   long thousands = (long)(value / 1000);
   long millions = (long)(value / 1000000);
   long billions = (long)(value / 1000000000);
   long trillions = (long)(value / 1000000000000L);


   if (trillions > 0)
       return formatValue(trillions) + " trillion";
   else if (billions > 0)
       return formatValue(billions) + " billion";
   else if (millions > 0)
       return formatValue(millions) + " million";
   else if (thousands > 0)
       return formatValue(thousands) + " k";

   else
       return ("" + value);
}