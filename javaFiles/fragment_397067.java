private static boolean checkInt(String str) {
    if ( ! str.matches("-?0*[0-9]{1,10}")) {
        return false;
    }
    long l = Long.valueOf(str);
    if ( l > Integer.MAX_VALUE || l < Integer.MIN_VALUE) {
        return false;
    }
    System.out.println("My number is: " + myNumber);
    return true;
}