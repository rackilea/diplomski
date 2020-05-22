public static void main(String[] args) {        
    String s = "babad";

    int starter = 0;

    if(s.length() % 2 == 0) 
        starter = 1;

    String answer = "";
    Boolean found = Boolean.FALSE;
    while(starter < s.length() - 1) {
        for(int i=0; i<=starter; i++) {
            if(isPelindrom(answer = s.substring(i, i+ s.length() - starter))) {
                found = Boolean.TRUE;
                break;
            }
        }
        if(found) break;
        starter = starter + 1;          
    }
    if(!found) answer = String.valueOf(s.charAt(0));
    System.out.println("The answer is " + answer);

}

public static Boolean isPelindrom(String s) {
    return s.equalsIgnoreCase(new StringBuilder(s).reverse().toString());
}