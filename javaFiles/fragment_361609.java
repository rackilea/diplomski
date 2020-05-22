public static byte[] getPublicKey(){ 
    try
    {                
        RSAPublicKey key = (RSAPublicKey)keystore.getCertificate("alias").getPublicKey();    
        return key.getModulus().toByteArray();

    }catch(Exception e){

    }
    return null;
}