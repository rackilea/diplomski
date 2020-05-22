Random r = new Random ();

StringBuilder sb = new StringBuilder();

for (int i = 0; i < 1000000; i++)
    sb.append ("0123456789".charAt(r.nextInt(10)));

long t = System.currentTimeMillis();
BigInteger bi = new BigInteger (sb.toString());
byte [] bytes = bi.toByteArray();
System.out.println(System.currentTimeMillis() - t);