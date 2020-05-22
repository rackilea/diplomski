public static String Decrypt1(String strIn) {
    String strOut = "";
    int lenIn = strIn.length();
    int i = 0;

    int A;
    int B;
    int nextIndex = 0;
    while (i < lenIn) {
        nextIndex = i+4;
        String aStr= strIn.substring(i, i+2);
        String bStr= strIn.substring(i + 2, nextIndex);

        System.out.println("astr:"+aStr);
        System.out.println("bstr:"+bStr);
        A = Integer.parseInt(aStr, 27);
        B = Integer.parseInt(bStr, 27);

        System.out.println("A:"+A);
        System.out.println("B:"+B);

        int C = A- B;
        System.out.println("C:"+C);

        String charStr = new String(Character.toChars(C));

        System.out.println("charStr :" +charStr);


        strOut+= charStr;
        i+=4;
    }

    System.out.println("output:"+strOut);
    return strOut;
}

 output:<flash><strToken>MICQNQGJYLUANOG</strToken><intCharID>32962493</intCharID></flash>