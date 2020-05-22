ByteBuffer buf = (ByteBuffer) record.value().get(("Price"));
    byte[] arr = new byte[buf.remaining()];
    buf.get(arr);
    BigInteger bi =new BigInteger(1,arr);
    BigDecimal bd = new BigDecimal(bi).movePointLeft(4);
    System.out.println(bd);