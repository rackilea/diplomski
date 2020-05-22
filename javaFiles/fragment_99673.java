public static void main(String[] args) {
    final float myfloat = 1F / 3F;

    //Using String.format 5 digist after the .
    final String fmtString = String.format("%.5f",myfloat);
    System.out.println(fmtString);

    //Same using NumberFormat
    final NumberFormat numFormat = NumberFormat.getNumberInstance();
    numFormat.setMaximumFractionDigits(5);
    final String fmtString2 = numFormat.format(myfloat);
    System.out.println(fmtString2);
}