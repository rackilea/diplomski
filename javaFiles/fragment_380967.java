len = in.read(buffer);
    buf2 = new byte[len+1];
    System.arraycopy(buffer, 0, buf2, 1, len);
    buf2[0] = 0;

    if(buf2[1] < 0)
        Ys = new BigInteger(buf2);
    else
        Ys = new BigInteger(Arrays.copyOfRange(buf2, 1, buf2.length));

    Sc = Ys.modPow(Xc, DiffieHellman.Group2.P);
    buffer = Sc.toByteArray();
    if(buffer[0] == 0)
        aeskey = hash.digest(Arrays.copyOfRange(buffer, 1, buffer.length));
    else
        aeskey = hash.digest(buffer);