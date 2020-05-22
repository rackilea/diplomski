public class CountTheChars {

    public static void main(String[] args) {

        String s = "Brother drinks brandy.";

        int countR = 0;

        System.out.println(count(s, countR));

    }

    public static int count(String s, int countR) {

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == 'r') {

                countR++;

            }

        }

        return countR;

    }

}