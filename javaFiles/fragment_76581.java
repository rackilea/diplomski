public class Mainclassexec {

    public static void main(String[] args) {
        String input = null;
        try {
            String capitalized = capitalize(input);
            System.out.println(capitalized);
        } catch (IOException e) {
            System.out.println(e.toString());
        } 
    }

    public static String capitalize(String s) throws IOException {
        System.out.println("Enter a string");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine(); 
        Character firstChar = s.charAt(0);
        String theRest = s.substring(1);
        return firstChar.toString().toUpperCase() + theRest;
    }
}