class testDouble {
public static void main(String[] args) {
    Double result = 20.001;
if (result % 1 == 0) {
    System.out.println(result + " Can be turned into integer, has no decimal part");
}
else {
    System.out.println(result + " Can not be turned into integer, has decimal part");
}
    result = 20.000;
if (result % 1 == 0) {
    System.out.println(result + " Can be turned into integer, has no decimal part");
    int intOfDouble = result.intValue();
    System.out.println(result + " Can be turned into integer " + intOfDouble);
}
}
}