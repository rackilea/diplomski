// use the correct pattern #0.00
DecimalFormat formatter = new DecimalFormat("#0.00");  // edited here.    
double randomValue = min + Math.random( ) * diff;
double tempRes = Math.floor(randomValue * 10);
double finalRes = tempRes/10;
System.out.println(formatter.format(finalRes));