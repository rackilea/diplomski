public class Test {
    public static void main(String[] args) {
        System.out.println("Type your text...");
        Scanner sc = new Scanner(System.in);
        System.out.println("Length of String: " + lengthOfString("I need your help programmers, please"));
        sc.close();
    }

    /**
     * Calculates the length of given string. Returns an integer.
     * 
     * @param string
     * @return 
     */
    private static int lengthOfString(String string) {
        int length = -1;
        while (true) {
            try {
                string.charAt(++length);
            } catch (StringIndexOutOfBoundsException exception) {
                break;
            }
        }
        return length;
    }
}