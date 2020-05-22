import java.util.Base64;

     try {
    // Encode using basic encoder
    String base64encodedString=Base64.getEncoder().encodeToString(Image.getBytes("utf-8"));
    //   System.out.println("Base64 Encoded String (Basic) :" +base64encodedString);
    // Decode
        byte[] base64decodedBytes = Base64.getDecoder().decode(base64encodedString);    
        String replaceableImage =   new String(base64decodedBytes, "utf-8");
        System.out.println("Original String:" + replaceableImage);
    }catch(UnsupportedEncodingException e){
        System.out.println("Error :" + e.getMessage());
    }