DecimalFormatSymbols dfs = new DecimalFormatSymbols();
dfs.setDecimalSeparator(',');
dfs.setGroupingSeparator('.');
DecimalFormat df = new DecimalFormat();
df.setDecimalFormatSymbols(dfs);

System.out.println(df.parse(stringToTest));