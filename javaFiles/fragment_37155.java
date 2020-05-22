double commission = 0.;
if (ExcAmount < 1000) {
    commission = result * 0.02;
} else {
    commission = result * 0.01;
}

result += commission;
String stringToPrint = "";
if (!yn) { //you could use meaningful variable names
    stringToPrint = "Commission = " + commission;
} else {
    stringToPrint = "Commission = Not charged";
}
System.out.println(stringToPrint + "\nTotal = " + (result - commission));