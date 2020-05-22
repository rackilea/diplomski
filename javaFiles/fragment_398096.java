double value = 1234.567890;
int numPlaces = 5;

String numberSigns = generateNumberSigns(numPlaces);
DecimalFormat fmt = new DecimalFormat ("0." + numberSigns);

System.out.println(fmt.format(value));