StockName stockName = new StockName("HUGE", "%Huge Fruit, Inc.", "Fruit Titanesque, Inc.");
System.out.printf("%s%n", stockName);
System.out.printf("%s%n", stockName.toString());
System.out.printf("%#s%n", stockName);
System.out.printf("%-10.8s%n", stockName);
System.out.printf("%.12s%n", stockName);
System.out.printf(Locale.FRANCE, "%25s%n", stockName);