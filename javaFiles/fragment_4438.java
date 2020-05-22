package problems;

public class WildCardCompare {

    public boolean compare(String str, String regex) {
        if(regex == null || str == null) {
            return false;
        }
        if(regex.equals("*")) {
            return true;
        }
        if(regex.equals("?") && str.length() == 1) {
            return true;
        }
        if(!regex.contains("*") && !regex.contains("?")) {
            return str.equals(regex);
        }

        String token = null;
        if(regex.contains("*")) {
            token = "*";
        }

        if(regex.contains("?")) {
            token = "?";
        }

        if(token != null) {
            //String before *, if any...
            String before = regex.substring(0, regex.indexOf(token));
            //String after *, if any...
            String after = regex.substring(regex.indexOf(token)+1, regex.length());

            boolean bmatches = true;
            if(before != null && before.length() != 0) {
                if(str.indexOf(before) == 0) {
                    bmatches = true;
                }
                else {
                    bmatches = false;
                }
            }
            boolean amatches = true;
            if(after != null && after.length() != 0) {
                if(str.indexOf(after) == (str.length() - after.length())) {
                    amatches = true;
                }
                else {
                    amatches = false;
                }
            }
            return bmatches && amatches;
        }

        return false;
    }

    public static void main(String args[])
    {
        boolean r;
        WildCardCompare compare = new WildCardCompare();
        r = compare.compare("a b hello", "a b *");
        System.out.println(r);
        r = compare.compare("a hello b", "a * b");
        System.out.println(r);
        r = compare.compare("a hello b", "aaaa*bbbb");
        System.out.println(r);
        r = compare.compare( "aaaaTbbbb", "aaaa*bbbb");
        System.out.println(r);
        r = compare.compare( "aT", "a?");
        System.out.println(r);
        r = compare.compare("AT",  "a?");
        System.out.println(r);
        r = compare.compare( "aXb", "a?b");
        System.out.println(r);
        r = compare.compare( "abc", "xyz");
        System.out.println(r);
    }
}