long roundedNumber;
while(noOfDigits< 1001){
noOfDigits = (curr*Math.log10(phi)) - Math.log10(fiveSqrt);
roundedNumber = (long)noOfDigits + 1;
System.out.println("curr : " + curr + "Digits : " + Math.round(roundedNumber));
curr++;
}