package stackoverflow.answers;

public class ParsingTest {

    public static void main(String[] args) {

        System.out.println("Result is " + extractInteger("010"));
        System.out.println("Result is " + extractInteger("1010"));
        System.out.println("Result is " + extractInteger("0001"));
        System.out.println("Result is " + extractInteger("0000"));
        System.out.println("Result is " + extractInteger("11A0"));

    }

    private static Integer extractInteger(String s) {
        Integer i = null;
        String t = s.replaceFirst("^0+(?!$)", "");
        try {
            i = Integer.valueOf(t);
        } catch (Exception e) {
            e.printStackTrace();
            // to be sure you return always something
            // null could be other value returned
            // in that case use a finally
            return 0;
        }
        return i;
    }

}