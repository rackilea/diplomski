public class Test {
    static String finalBinaryString ="";
    public static void main(String[] args) {

        String s = "0";
        int count =3;

        System.out.println(aMethod(s,count));

    }

    private static String aMethod(String s,int count) {

        String t ="";

        int iteration =0;
        for(int i=0;i<s.length();i++){

            char f = s.charAt(i);
            int tt = 1- Integer.parseInt(String.valueOf(f));
            t += String.valueOf(tt);
        }
        finalBinaryString = s+t;
        if(iteration<count)
            aMethod(finalBinaryString,--count);
        return finalBinaryString;
    }

}