double amount =200.0;
Locale locale = new Locale("es", "ES");      
NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
System.out.println(currencyFormatter.format(amount));

locale = new Locale("es", "cu");      
currencyFormatter = NumberFormat.getCurrencyInstance(locale);
System.out.println(currencyFormatter.format(amount));