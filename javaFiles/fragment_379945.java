// key pair is in 'kp'
KeyFactory kf = KeyFactory.getInstance("RSA");
RSAPrivateCrtKeySpec ks = kf.getKeySpec(
    kp.getPrivate(), RSAPrivateCrtKeySpec.class);
System.out.println("<RSAKeyValue>");
System.out.println("    <Modulus>" + ks.getModulus() + "</Modulus>");
System.out.println("    <Exponent>" + ks.getPublicExponent() + "</Exponent>");
System.out.println("    <P>" + ks.getPrimeP() + "</P>");
System.out.println("    <Q>" + ks.getPrimeQ() + "</Q>");
System.out.println("    <DP>" + ks.getPrimeExponentP() + "</DP>");
System.out.println("    <DQ>" + ks.getPrimeExponentQ() + "</DQ>");
System.out.println("    <InverseQ>" + ks.getCrtCoefficient() + "</InverseQ>");
System.out.println("    <D>" + ks.getPrivateExponent() + "</D>");
System.out.println("</RSAKeyValue>");