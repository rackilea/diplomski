// Define the number factory.
NumberFormat nf = NumberFormat.getIntegerInstance(); // Specify specific format here.
NumberFormatter nff = new NumberFormatter(nf);
DefaultFormatterFactory factory = new DefaultFormatterFactory(nff);

// Define the decimal factory.
DecimalFormat df = new DecimalFormat(); // And here..
NumberFormatter dnff = new NumberFormatter(df);
DefaultFormatterFactory factory2 = new DefaultFormatterFactory(dnff); 

// Then you set which factory to use.
JFormattedTextField field = new JFormattedTextField();
field.setFormatterFactory(factory);
//field.setFormatterFactory(factory2);