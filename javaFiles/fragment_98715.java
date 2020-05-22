String s1 ="aaaassssaassaass";
    String s2 = "aa";

   Pattern pattern =Pattern.compile(s2);
   Matcher matcher = pattern.matcher(s1); 
    int i = 0;
    while(matcher.find()){
        i++;
    }
    //Out put will be 4
    System.out.println(i);