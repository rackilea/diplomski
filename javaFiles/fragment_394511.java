public class MyClass {
    public static void main(String args[]) {
        int counter=0;
        String s = "abcbaba";
        char string_array[] = s.toCharArray();
        for(int i=0; i<s.length(); i++){
            for(int j=i; j<=s.length(); j++){
                if(i != j){
                    String s1 = s.substring(i,j);
                    String rev = "";
                    char complianceChar = s1.charAt(0);
                    boolean isSpecialPalindrom = true;
                    boolean isLengthEven = s1.length()%2==0;
                    for(int z=0; z<s1.length(); z++) {
                        char c = s1.charAt(s1.length()-1-z);
                        rev = rev + c;
                        boolean isMiddleChar = (z == (s1.length()-1)/2);
                        if(isSpecialPalindrom && (isLengthEven || !isMiddleChar)) {
                            isSpecialPalindrom = (c == complianceChar);
                        }
                    }
                    int count = s1.compareTo(rev);
                    if(count == 0 && isSpecialPalindrom){
                        System.out.println(rev);
                        counter++;
                    }
                }
            }
        }
        System.out.println(counter);
    }
}