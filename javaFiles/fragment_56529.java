public static synchronized String bytesToHex(byte [] buf){
        StringBuffer strbuf = new StringBuffer(buf.length * 2);
        int i;
        for (i = 0; i < buf.length; i++) {
            if (((int) buf[i] & 0xff) < 0x10){
                strbuf.append("0");
            }
            strbuf.append(Long.toString((int) buf[i] & 0xff, 16));
        }
        return strbuf.toString();
    }

    public synchronized static byte[] hexToBytes(String hexString) {
         byte[] b = new BigInteger(hexString,16).toByteArray();     
         return b;
    }