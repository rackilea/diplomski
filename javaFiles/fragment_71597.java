for (int i = 0; i < bitString.length(); i++) {
        char temp = bitString.charAt(i);
        String temp2 = "" + temp + "";
        for (int j = 0; j < binary.length; j++) {
            if (temp2.equalsIgnoreCase(binary[j])) {
                hexString = hexString + hex[j];
            }
        }
    }