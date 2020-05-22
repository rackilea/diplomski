for(int i = 0; i < s.length(); i++) { 
    d = Math.pow(10, s.length() - i - 1); 
    int value = s.charAt(i) - '0';
    System.out.println(value + " * " + d
                       + " = " + (value*d)); 
}