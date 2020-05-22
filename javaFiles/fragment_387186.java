public static String ComputeHash(String password) throws NoSuchAlgorithmException, UnsupportedEncodingException{

    MessageDigest md = MessageDigest.getInstance("SHA-1");
    md.reset();
    md.update(password.getBytes("UTF-8"));
    return toHexString(md.digest());

}

private static String toHexString(byte[] data){
    Formatter formatter = new Formatter();
    for(byte b : data){
        formatter.format("%02x", b);
    }
    String result = formatter.toString();
    formatter.close();
    return result;
}