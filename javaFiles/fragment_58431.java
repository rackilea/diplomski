public static void getYear(Object c){
    int year_digit=0;
    String temp;

    for(int i=0;i<4;i++){
        char ch = getInputChar();
        temp = Character.toString(ch);
        year_digit = Integer.parseInt(temp);
        System.out.println(year_digit);
    }
    }