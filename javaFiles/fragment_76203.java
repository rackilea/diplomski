DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.getDefault());
symbols.setGroupingSeparator('+');
NumberFormat nf = new DecimalFormat("000,000", symbols);

int x = 3250;
System.out.println(nf.format(x));