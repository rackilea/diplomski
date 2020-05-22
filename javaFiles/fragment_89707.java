public class Test{

    public static void main(String args[]){
        String[] tests=new String[5];

        tests[0]="MyClass";
        tests[1]="Short";
        tests[2]="thsrjtyzfgnmytkzrhjstk";
        tests[3]="tatm";
        tests[4]="The result is good";

        for(int i=0;i<tests.length;i++){
            System.out.println(tests[i]+ "- Encrypted:" + isProbablyEncrypted(tests[i]));
        }


    }

    public static boolean isProbablyEncrypted(String in){
        int noOfWords= countOccurrences(in, ' ') + countCaps(in);
        if (noOfWords==0){
            return true;
        }else{
            double averageWordLength=(double)(in.length())/(noOfWords+1);

            if (averageWordLength>15){
                return true;
            }else{
                return false;
            }
        }
    }

    public static int countOccurrences(String haystack, char needle)
    {
        int count = 0;
        for (int i=0; i < haystack.length(); i++)
        {
            if (haystack.charAt(i) == needle)
            {
                 count++;
            }
        }
        return count;
    }

    public static int countCaps(String in){
        int caps=0;
        for (int i=0; i<in.length(); i++) {
            if (Character.isUpperCase(in.charAt(i)))caps++;
        }
        return caps;
    }
}