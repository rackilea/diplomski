Currency currency = Currency.getInstance(currentLocale);
String symbol = currency.getSymbol();
if(string.startsWith(symbol) || string.endsWith(symbol)){
    System.out.println("valid");
}else{
    System.out.println("invalid");
}