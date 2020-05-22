long empieza  = 0;
long duracion = 0;
empieza  = System.currentTimeMillis();
cbxUnidad.addItem("TODOS");
duracion = (System.currentTimeMillis() - empieza);
java.text.NumberFormat nf = new java.text.DecimalFormat("#0.00000");
String totalTime = nf.format(totalTime/1000d);
System.out.println("Adding the item TODOS last " + totalTime+ " seconds");