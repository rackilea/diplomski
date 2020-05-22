BigInteger m1 = new BigInteger("200");
BigInteger m2 = new BigInteger("-100");

BigInteger em1 = paillier.Encryption(m1);
BigInteger em2 = paillier.Encryption(m2);

BigInteger product_em1em2 = em1.multiply(em2).mod(paillier.nsquare);
System.out.println("decrypted Result: " + paillier.Decryption(product_em1em2).toString());