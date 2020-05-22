NumberFormat df = NumberFormat.getCurrencyInstance();
DecimalFormatSymbols dfs = new DecimalFormatSymbols();
dfs.setCurrencySymbol("$");
dfs.setGroupingSeparator('.');
dfs.setMonetaryDecimalSeparator('.');
((DecimalFormat) df).setDecimalFormatSymbols(dfs);
System.out.println(df.format(3333454));