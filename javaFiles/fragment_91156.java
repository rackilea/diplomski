// decode data from base 64
    private static byte[] decodeBase64(String dataToDecode)
        {
            byte[] dataDecoded = Base64.decode(dataToDecode, Base64.DEFAULT);
            return dataDecoded;
        }

//enconde data in base 64
        private static byte[] encodeBase64(byte[] dataToEncode)
        {
            byte[] dataEncoded = Base64.encode(dataToEncode, Base64.DEFAULT);
            return dataEncoded;
        }