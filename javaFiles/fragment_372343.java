public class loopStringAnalysis {

    public static String replaceText(String s1, String s2) {
        StringBuilder newStringBuild = new StringBuilder();
        int count = 0;
        int count1 = 0;
        for (int i = 0, i1 = 0; i < s1.length() && i1 < s2.length(); i = i + 1) {
            if (s1.charAt(i) == '(') {
                count = count + 1;
            } else if (s1.charAt(i) == ')') {
                count = count - 1;
            } else if (count == 0) {
                newStringBuild.append(s1.charAt(i));
            } else if (count != 0) {
                while (count1 == 0) {
                    if (s2.charAt(i1) == '(') {
                        count1 = count1 + 1;
                    } else if (s2.charAt(i1) == ')') {
                        count1 = count1 - 1;
                    }
                    i1 = i1 + 1;
                }
                while (count1 != 0) {
                    if (s2.charAt(i1) == '(') {
                        count1 = count1 + 1;
                    } else if (s2.charAt(i1) == ')') {
                        count1 = count1 - 1;
                    }
                    if (count1 != 0) {
                        newStringBuild.append(s2.charAt(i1));
                    }
                    i1 = i1 + 1;
                }
                while (count != 0) {
                    i = i + 1;
                    if (s1.charAt(i) == '(') {
                        count = count + 1;
                    } else if (s1.charAt(i) == ')') {
                        count = count - 1;
                    }
                }
            }
        }
        return newStringBuild.toString();
    }

    public static void main(String [] args){
        System.out.println(replaceText("a ((nested) example) with (three) replacements (to (handle))",
            "the replacements are (answer) and (really (two) not three)"));
    }
}