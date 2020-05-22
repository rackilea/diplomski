public class StringReplacer {

    public static void main(String[] args) {
        String str1 = "New York";
        String str2 = "New Jersy";

        for(String s : str1.split("(?i)[" + str2 +"]")){
            if(s.trim().length() > 0){
                str1 = str1.replace(s, "+");
            }
        }

        System.out.println(str1); // Prints New Y+r+
    }

}