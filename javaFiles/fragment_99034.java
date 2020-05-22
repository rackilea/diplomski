public static void main(String args[]) {
        String partOfCer = "MIIHSjCCBjKgAwIBAgIQQuw1emUfNRlPD/euDuzBjDANBgkqhkiG9w0BAQUFADCB" + "5TELMAkGA1UEBhMCRVMxIDAeBgkqhkiG9w0BCQEWEWFjQGFjYWJvZ2FjaWEub3Jn";
        byte[] dec1_byte = Base64.decodeBase64(partOfCer.getBytes());
//        String dec1 = new String(dec1_byte);
        byte[] newBytes = Base64.encodeBase64(dec1_byte);
        String newStr = new String(newBytes);
        System.out.println(partOfCer);
        System.out.println(newStr);
        System.out.println(partOfCer.equals(newStr));
    }