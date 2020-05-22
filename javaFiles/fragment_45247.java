public class Test {

    static String chars = "qwertyuiopasdfghjkl;zxcvbnm,.";

    public static void main(String[] args) {
        System.out.println(getNeighboringKeys('f'));
        System.out.println(getNeighboringKeys('u'));
        System.out.println(getNeighboringKeys('m'));
        System.out.println(getNeighboringKeys('q'));
    }

    public static String getNeighboringKeys(char key) {
        StringBuffer result = new StringBuffer();
        for (char c : chars.toCharArray()) {
            if (c!=key && distance(c,key)<2) {
                result.append(c);
            }
        }
        return result.toString();
    }

    public static double distance(char c1, char c2) {
        return Math.sqrt(Math.pow(colOf(c2)-colOf(c1),2)+Math.pow(rowOf(c2)-rowOf(c1),2));
    }

    public static int rowOf(char c) {
        return chars.indexOf(c) / 10;
    }

    public static int colOf(char c) {
        return chars.indexOf(c) % 10;
    }
}