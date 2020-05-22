public String encode(String arg_text) throws IllegalBlockSizeException, BadPaddingException {
    byte[] encrypt = arg_text.getBytes();

    if(encrypt.length % 8 != 0){ //not a multiple of 8
        //create a new array with a size which is a multiple of 8
        byte[] padded = new byte[encrypt.length + 8 - (encrypt.length % 8)];

        //copy the old array into it
        System.arraycopy(encrypt, 0, padded, 0, encrypt.length);
        encrypt = padded;
    }

    return new String(Base64.encodeBase64URLSafe(encrypter.doFinal(b)), "US-ASCII");
}