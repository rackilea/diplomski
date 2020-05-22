public Double convert(String value){
    DecimalFormat df = new DecimalFormat("0.##E0");
    String formattedVal = df.format(value);      
    return Double.parseDouble(formattedVal);
}

DecimalFormat df = new DecimalFormat("0.##E0");
Double d = convert("1e4");
String dAsString = df.format(d);
System.out.println(dAsString);