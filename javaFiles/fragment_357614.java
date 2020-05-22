import java.util.StringTokenizer;

class A {

    public static void main(String[] args) {
        String str = "Monday Tuesday Wednesday";
        String newstr = "";
        StringTokenizer S = new StringTokenizer(str);
        while(S.hasMoreTokens() == true) {
            String day = S.nextToken();
            if(day.equals("Tuesday")) {
                continue;
            } else {
                newstr = newstr + (day + " ");
            }
        }
        System.out.println(newstr);
    }
}