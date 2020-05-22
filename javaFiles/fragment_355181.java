double num1 = 123456789L;
double num2 = 123456789L;
String result = num1*num2+"";
if(result.contains("E")){ //if result is in scientific notation
    //take the first 6 characters only and part containing the E, drop everything else.
    result = result.substring(0, 6) + result.substring(result.indexOf("E"));
}
System.out.println("Result is = " + result);