public static void main (String[] args) 
{
    char[] st = "Hello World".toCharArray();
    char[] substr = "llo".toCharArray();

    for(int contains = 0; contains < st.length - substr.length; contains++) {
        int j;
        for(j = 0; j < substr.length; j++) {
            if(st[contains + j] != substr[j]) {    // mismatch    
                break;
            }
        }
        if (j == substr.length)   // Every character in substr has been matched
           System.out.println("Contains");
    }
}