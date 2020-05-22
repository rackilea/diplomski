NumberFormat fmt = NumberFormat.getNumberInstance(Locale.US);
double d = fmt.parse("-0.05").doubleValue(); //-0.05

fmt = NumberFormat.getNumberInstance(Locale.FRENCH);
d = fmt.parse("-0.05").doubleValue(); //-0.0
d = fmt.parse("-0,05").doubleValue(); //-0.05