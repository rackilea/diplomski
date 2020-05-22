final String str = new String(ident);
char m;
for (int j = 0; j < x.length(); j++) {
    m = x.charAt(j);
    if (str.indexOf(m) >= 0) {
       System.out.println("Token " + j + " is " + m+" is identifier");
    } else {
       System.out.println("Token " + j + " is " + m);
    }
}