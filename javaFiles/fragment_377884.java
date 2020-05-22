String strEncrypt = "58"; String strKey = "apple"; 
     String intSeed = "6"; String encryptedString = RunRC4(strEncrypt, strKey);
}

public static String RunRC4(String sMessage, String strKey) {
    int kLen = 0, x = 0, y = 0, i = 0, j = 0, temp = 0;
    int[] s = new int[500];
    int[] k = new int[500];
    String RunRC4 = "";
    String finalChar = "";
    kLen = strKey.length();

    for (i = 0; i <= 255; i++) {
        s[i] = i;
        String s1 = "";
        int modular = i % kLen;
        s1 = strKey.substring(modular, modular + 1);
        char c1 = s1.charAt(0);
        k[i] = (int) c1;
    }

    j = 0;
    for (i = 0; i <= 255; i++) {
        j = (j + k[i] + s[i]) % 255;
        temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }

    // 'Drop n bytes from keystream
    x = 0;
    y = 0;
    for (i = 0; i <= 3072; i++) {
        x = (x + 1) % 255;
        y = (y + s[x]) % 255;
        temp = s[x];
        s[x] = s[y];
        s[y] = temp;

    }

    // 'Encode/Decode
    for (i = 0; i <= sMessage.length(); i++) {
        x = (x + 1) % 255;
        y = (y + s[x]) % 255;
        temp = s[x];
        s[x] = s[y];
        s[y] = temp;

        String s2 = sMessage.substring(i);
        if (s2.equalsIgnoreCase("")) {
            return finalChar;
        } else {
            char c2 = s2.charAt(0);
            int xy = s[x] + s[y];
            int value = s[xy % 255];
            RunRC4 = RunRC4 + (value ^ (int) c2);
            finalChar = finalChar
                    + (Character.toString((char) Integer.parseInt(RunRC4)));
            RunRC4 = "";
        }
    }

    return finalChar;
}