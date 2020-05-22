long mantissa = Double.doubleToLongBits(f) & 0x000fffffffffffffL;
    long exponent = Double.doubleToLongBits(f) & 0x7ff0000000000000L;
    long sign = Double.doubleToLongBits(f)  & 0x8000000000000000L;

    // Exponent is encoded with a bias, so to see the actual exponent
    // value:
    exponent >>= (13 * 4);
    exponent -= 1023;

    // Leading 1 bit for mantissa isn't stored:
    mantissa |= 0x0010000000000000L;

    if (sign != 0) sign = 1;
    System.out.println("" + sign + "/" + mantissa + "/" + exponent);