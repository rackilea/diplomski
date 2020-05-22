public static byte[] calculateMAC(byte[] _aiOutBufferForMacCalculation, byte[] key) {
    try{

        Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
        SecretKeySpec secret_key = new SecretKeySpec(key, "HmacSHA256");
    ...
    }