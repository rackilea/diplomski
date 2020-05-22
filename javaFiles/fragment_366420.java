List a2 = new ArrayList<String>(a1.size());
    int line = 0;
    for(String s: a1) {
       int i = 0;
       for(char c: str.trim().toCharArray() {
           if(!Character.isDigit(c) {
               System.out.println("In line" + line + " char " + i + " isn't digit")
           }
           i++;
       }  
       line++;    
    }