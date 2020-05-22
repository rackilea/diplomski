public class DotSubstring {

    public static void main(String[] args) {
        String s = "1.2.3.4";
        int secondDotPosition = findSecondDotPosition(s);
        if (secondDotPosition > 0) {
            System.out.println(s.substring(0, secondDotPosition));
        } else {
            System.out.printf("ERROR: there is not a 2nd dot in '%s'%n", s);
        }
    }

    private static int findSecondDotPosition(String s) {
        int result = -1;
        int dotsToFind = 2;
        char[] ca = s.toCharArray();
        for (int i = 0; i < ca.length; ++i) {
            if (ca[i] == '.') --dotsToFind;
            if (dotsToFind == 0) return i;
        }
        return result;
    }

}