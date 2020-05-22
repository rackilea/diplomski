String[] words = s.split(" ");
String numberString = words[words.length-1];

try{
    double[] array = new double[]{Double.parseDouble(numberString)};
}
catch(NumberFormatException e){

    e.printStackTrace();
}