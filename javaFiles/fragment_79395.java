public int tenToBase(int n) {
    String temp = ""
    while (value2 >= base2) {
        remainder = value2%base2;
        value2 = value2/base2;
        temp = remainder + temp;
    }
    System.out.println(temp);
    return value2;
}