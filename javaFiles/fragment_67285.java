public static byte[] getRoger(String val) throws NumberFormatException,
        NullPointerException {
    byte[] result = new byte[2];
    byte[] holder = new BigInteger(val, 2).toByteArray();

    if (holder.length == 1) result[0] = holder[0];
    else if (holder.length > 1) {
        result[1] = holder[holder.length - 2];
        result[0] = holder[holder.length - 1];
    }
    return result;
}