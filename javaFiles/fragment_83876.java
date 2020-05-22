String num = "31254";

    int maxIndex = 0;
    char maxString = num.charAt(0);
    for (int i = 1; i < num.length(); i++) {
        if (num.charAt(i) > maxString) {
            maxString = num.charAt(i);
            maxIndex = i;
        }
    }
    System.out.println(maxString);
    System.out.println(maxIndex);

    String str1 = num.substring(1,maxIndex);
    String str2 = num.substring(maxIndex+1,num.length());
    String str3 = num.charAt(maxIndex)+str1+num.charAt(0)+str2;
    System.out.println(str3);