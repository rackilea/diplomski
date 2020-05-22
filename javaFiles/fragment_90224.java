public static BigInteger twosComplement(BigInteger original)
{
    // for negative BigInteger, top byte is negative  
    byte[] contents = original.toByteArray();

    // prepend byte of opposite sign
    byte[] result = new byte[contents.length + 1];
    System.arraycopy(contents, 0, result, 1, contents.length);
    result[0] = (contents[0] < 0) ? 0 : (byte)-1;

    // this will be two's complement
    return new BigInteger(result);
}

public static void main(String[] args)
{
    BigInteger a = new BigInteger("-173B8EC504479C3E95DEB0460411962F9EF2ECE0D3AACD749BE39E1006FC87B8", 16);
    BigInteger b = twosComplement(a);

    System.out.println(a.toString(16).toUpperCase());
    System.out.println(b.toString(16).toUpperCase());

    // for comparison, from question:
    System.out.println("E8C4713AFBB863C16A214FB9FBEE69D0610D131F2C55328B641D61EFF9037848");
}