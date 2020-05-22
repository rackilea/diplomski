NumberFormat.getNumberInstance(java.util.Locale.US).parse("265,858");

int test = 0;
try {
    test = NumberFormat.getNumberInstance(java.util.Locale.US).parse("265,858").intValue();
} catch (ParseException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}
System.out.println("" + test);