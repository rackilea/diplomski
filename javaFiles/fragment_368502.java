String str2 = "abcdefg";
    String toCompare = "fdjkhireuhsdthuirdf(g"; //looks like this changed when  you updated your question
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < str2.length(); i++) {
        char ch = str2.charAt(i);
        int charInt1 = ch % 3;

        sb.append(1 + Math.round(charInt1));

        if (i < toCompare.length()) {
            char ch2 = toCompare.charAt(i);
            int charInt2 = ch2 % 3;
            sb.append(1 + Math.round(charInt2));
        }
    }
    System.out.println(sb.toString()); // printed 21321223331121