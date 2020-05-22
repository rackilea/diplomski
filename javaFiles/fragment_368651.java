public class Test055 {

    public static void main(String[] args) {
        // System.out.println(expMatch("abddddc", "a*c"));

        System.out.println(expMatch("adcax", "a*c"));
        System.out.println(expMatch("adcax", "a*c*"));

        System.out.println(expMatch("adcacm", "*"));
        System.out.println(expMatch("adcacmmm", "a*c"));
        System.out.println(expMatch("adcacmmmc", "a*c"));
        System.out.println(expMatch("adcac", "a*c"));

        System.out.println(expMatch("adcacxb", "a*c.b"));
        System.out.println(expMatch("adcacyyb", "a*c.b"));
        System.out.println(expMatch("adcacyyb", "a*c*b"));

    }

    public static boolean expMatch(String str, String pat)
    {
        // System.out.println("=====================");
        // System.out.println("str=" + str);
        // System.out.println("pat=" + pat);

        if (pat.length() == 0 && str.length() > 0) {
            return false;
        } else if (pat.length() == 0 && str.length() == 0) {
            return true;
        } else if (pat.charAt(0) == '.'){
            return str.length() >= 1 && expMatch(str.substring(1), pat.substring(1));
        }else if (pat.charAt(0) != '*'){
            return str.length() >= 1 && pat.charAt(0) == str.charAt(0) && expMatch(str.substring(1), pat.substring(1));
        }else{
            // Now let's handle the tricky part

            // (1) Look for the 1st non-star in pattern
            int k=-1;
            char ch = ' ';
            for (int i=0; i<pat.length(); i++){
                if (pat.charAt(i) != '*'){
                    k = i;
                    ch = pat.charAt(k);
                    break;
                }
            }

            if (k==-1){
                // (2A) only stars found in pattern, OK, any str matches that
                return true;
            }else{
                // (2B) do full search now checking all  
                // possible candidate chars in str that 
                // match the char ch from pattern
                for (int i=0; i<str.length(); i++){
                    if (str.charAt(i)==ch){
                        boolean b = expMatch(str.substring(i+1), pat.substring(k+1));
                        if (b) return true;
                    }
                }
                return false;
            }
        }
    }
}