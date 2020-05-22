public class Testtest {

    public static void main(String[] args) {
        char a[] = "NO70JE3A4Z28X1GBQKFYLPDVWCSHUTM65R9I".toCharArray(); // line added to have array "a"

        int rcounter = 1;
        int ccounter = 1;
        Map<String, String> soup = new HashMap<String, String>();
        for (int i = 0; i < a.length; i++) {
            if (ccounter == 7) {
                ccounter = 1;
                rcounter++;}
            String row = Integer.toString(rcounter);
            String column = Integer.toString(ccounter);

            soup.put(new String(""+a[i]), row + column); // line changed to add a String, not a Char, to HashMap
            ccounter++;
            if (i == 36) {
                break;
            }
            System.out.println(row+column);
        }

        System.out.println("result: " + soup.get("N") + soup.get("I")); // changed to display result, rather than return it
    }
}