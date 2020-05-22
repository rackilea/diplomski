String s1 = "10010001000001001";
    int len = 0, preLen = 0;
    for (int i = 0; i < s1.length(); i++) {
        len = 0;
        if (s1.charAt(i) == '1') {
            for (int j = i + 1; j < s1.length(); j++) {
                if (s1.charAt(j) == '0') {
                    len++;
                } else {
                    break;
                }
            }
            if (preLen < len) {
                preLen = len;
            }
        }
    }
    System.out.println("Len =" + preLen);