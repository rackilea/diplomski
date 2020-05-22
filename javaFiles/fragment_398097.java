double value = 1234.567890;
int numPlaces = 5;

String numberSigns = "";
for (int i = 0; i < numPlaces; i++) {
    numberSigns += "#";
}

DecimalFormat fmt = new DecimalFormat ("0." + numberSigns);

System.out.println(fmt.format(value));