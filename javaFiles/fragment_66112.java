String sign = "c";
if (value < 0) {
    sign = "d";
    value = -1 * value;
}
String val = value + "d"

byte[] comp3Bytes = new BigInteger(val, 16).toByteArray();