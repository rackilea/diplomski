Integer.
 parseInt("0", 10) returns 0
 parseInt("473", 10) returns 473
 parseInt("+42", 10) returns 42
 parseInt("-0", 10) returns 0
 parseInt("-FF", 16) returns -255
 parseInt("1100110", 2) returns 102
 parseInt("2147483647", 10) returns 2147483647
 parseInt("-2147483648", 10) returns -2147483648
 parseInt("2147483648", 10) throws a NumberFormatException
 parseInt("99", 8) throws a NumberFormatException
 parseInt("Kona", 10) throws a NumberFormatException
 parseInt("Kona", 27) returns 411787

    int x = 10101;
    Integer.toBinaryString(x);
    Integer.toHexString(x);
    Integer.toOctalString(x);
    Integer.toUnsignedLong(x);