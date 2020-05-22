public static void main(String[] args) {
        String string = "ajeIokluj";    
        String s = eliminateVowels(string);   
        System.out.println(s); 
    }

    private static String eliminateVowels(String string) {
        String s = string.replaceAll("[aeiouAEIOU]","");
        return s;
    }