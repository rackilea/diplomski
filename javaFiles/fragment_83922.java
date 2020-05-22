public byte[] encodePublicKey(RSAPublicKey key) throws IOException
   {
       ByteArrayOutputStream out = new ByteArrayOutputStream();
       /* encode the "ssh-rsa" string */
       byte[] sshrsa = new byte[] {0, 0, 0, 7, 's', 's', 'h', '-', 'r', 's', 'a'};
       out.write(sshrsa);
       /* Encode the public exponent */
       BigInteger e = key.getPublicExponent();
       byte[] data = e.toByteArray();
       encodeUInt32(data.length, out);
       out.write(data);
       /* Encode the modulus */
       BigInteger m = key.getModulus();
       data = m.toByteArray();
       encodeUInt32(data.length, out);
       out.write(data);
       return out.toByteArray();
   }

   public void encodeUInt32(int value, OutputStream out) throws IOException
   {
       byte[] tmp = new byte[4];
       tmp[0] = (byte)((value >>> 24) & 0xff);
       tmp[1] = (byte)((value >>> 16) & 0xff);
       tmp[2] = (byte)((value >>> 8) & 0xff);
       tmp[3] = (byte)(value & 0xff);
       out.write(tmp);
   }