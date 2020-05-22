String str1 = "abcdef";
    String str2 = "abcgef";
    String com = "";
    String com2 = "";
    int a;
    int b;

    for (int i = 0; i < str1.length(); i++) {
    //counts removed (never used)
        for (int j = 0; j < str2.length(); j++) {
            a = i;
            b = j;
            com2 = ""; // Reset before start a new Check Loop
            while (str1.charAt(a) == str2.charAt(b)) {
                com2 = com2 + str1.charAt(a);
                if (com2.length() > com.length()) {
                    com = com2;
                }
                /**
                * length() goes from 0 (empty String) to n
                * index 0 is the first char in that String
                * so you need to adjust that (the simple way is -1)
                */
                if(a < str1.length()-1) {
                    a++;
                }
                if(b < str2.length()-1) {
                    b++;
                }
                //check for end of String -> Exit loop
                if(a >= str1.length()-1 && b >= str2.length()-1) {
                    break;
                }
            }
        }
    }
    System.out.println(com);
}