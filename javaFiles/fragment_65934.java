public class StringSplit {

    public static void main(String [] sm){
        String str = "Google Facebook Apple AT&T";
        // If you have more than one whitespace then better use \\s+
        String[] names = str.split("\\s");
        for(int i =0; i<names.length; i++){
            System.out.println(i +" : " + names[i]);
        }
    }
}