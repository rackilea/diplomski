// ASCII to Hex
        char[] c = asciiValue.toCharArray();
        StringBuffer hexValue = new StringBuffer();
        for(int i=0; i<c.length; i++) {
            hexValue.append(Integer.toHexString((int)c[i]));
        }
        String hexString = hexValue.toString();

        // Hex to RGB
        ArrayList<Color> rgbValues = new ArrayList<Color>();
        while(hexString.length() >= 6) {
            String tempval = hexString.substring(0,6);
            rgbValues.add(Color.decode(tempval));
            hexString = hexString.substring(tempval.length(), hexString.length());
            if(hexString.length() < 6) {
                String hexExtra = hexString;
                System.out.println("EXTRA DATA: " + hexExtra);
            }
        }