private String HexToBase64(String hex) {
        char[] base64Digits = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();
        String base64 = "";
        int group;     
        for (int i = 0; i < 30; i += 6) {
            group = Integer.parseInt(mySubString(hex, i, 6), 16);
            base64 += base64Digits[(group >> 18) & 0x3f];
            base64 += base64Digits[(group >> 12) & 0x3f];
            base64 += base64Digits[(group >> 6) & 0x3f];
            base64 += base64Digits[group & 0x3f];
        }
        group = Integer.parseInt(mySubString(hex, 30, 2), 16);
        base64 += base64Digits[(group >> 2) & 0x3f];
        base64 += base64Digits[(group << 4) & 0x3f];
        base64 += "==";
        return base64;
    }
    private String mySubString(String myString, int start, int length) {
        return myString.substring(start, Math.min(start + length, myString.length()));
    }
    private String CSUUID(String csuuid) {
        String hex = csuuid.replaceAll("[{}-]", ""); // remove extra characters
        String a = mySubString(hex, 6, 2) + mySubString(hex, 4, 2) + mySubString(hex, 2, 2) + mySubString(hex, 0, 2);
        String b = mySubString(hex, 10, 2) + mySubString(hex, 8, 2);
        String c = mySubString(hex, 14, 2) + mySubString(hex, 12, 2);
        String d = mySubString(hex, 16, 16);
        hex = a + b + c + d;
        String base64 = HexToBase64(hex);               
        //return base64.getBytes(StandardCharsets.UTF_8);
        return base64;
    }