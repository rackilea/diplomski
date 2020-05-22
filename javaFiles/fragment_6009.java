public static boolean isUTF8(String s){
    try{
        byte[]bytes = s.getBytes("UTF-8");
    }catch(UnsupportedEncodingException e){
        e.printStackTrace();
        System.exit(-1);
    }
    return true;
}