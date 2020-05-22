BigDecimal bd = new BigDecimal("15.25");
NumberFormat currency = NumberFormat.getCurrencyInstance();
NumberFormat percent = NumberFormat.getPercentInstance();

System.out.println( currency.format( bd.doubleValue() ) ); //In Brazil outputs R$ 15,25
System.out.println( percent.format( bd.doubleValue() ) ); // 1.525%