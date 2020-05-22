public class Test {
    public static void main(String[] args) {
        String regexp = "^[ a-zA-Z0-9!~`@#$%\\\\^\\[\\]]+$";
        String[] testdata = new String[] {
                "abc",
                "2332",
                "some@test",
                "test [ and ] test end",
                // Following sample will not match the pattern.
                "äöüßµøł"
        };
        for (String toExamine : testdata) {
            if (toExamine.matches(regexp)) {
                System.out.println("Match: " + toExamine);
            } else {
                System.out.println("No match: " + toExamine);
            }
        }
    }
}