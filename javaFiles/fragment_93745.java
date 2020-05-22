byte[] r = new BigInteger(1,Arrays.copyOfRange(signature,0,32)).toByteArray();
    byte[] s = new BigInteger(1,Arrays.copyOfRange(signature,32,64)).toByteArray();
    byte[] der = new byte[6+r.length+s.length];
    der[0] = 0x30; // Tag of signature object
    der[1] = (byte)(der.length-2); // Length of signature object
    int o = 2;
    der[o++] = 0x02; // Tag of ASN1 Integer
    der[o++] = (byte)r.length; // Length of first signature part
    System.arraycopy (r,0, der,o, r.length);
    o += r.length;
    der[o++] = 0x02; // Tag of ASN1 Integer
    der[o++] = (byte)s.length; // Length of second signature part
    System.arraycopy (s,0, der,o, s.length);