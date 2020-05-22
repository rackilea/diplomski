import java.util.stream.Stream;

public class Center {

    public Center() {
    }

    public static String center (String str, int length) {
        if (str.length() > length) {
            return str.substring(0, length);
        } else if (str.length() == length) {
            return str;
        } else {
            int leftPadding = (length - str.length()) / 2;
            StringBuilder leftBuilder = new StringBuilder();
            for (int i = 0; i < leftPadding; i++) {
                leftBuilder.append(" ");
            }

            int rightPadding = length - str.length() - leftPadding;
            StringBuilder rightBuilder = new StringBuilder();
            for (int i = 0; i < rightPadding; i++) {
                rightBuilder.append(" ");
            }

            return leftBuilder.toString() + str + rightBuilder.toString();
        }
    }

    public static void main(String[] args) {

        String input = "Street Road Patta 55,053888 Alur Satta,Keidaj";

        Stream.of(input.split(",")).map(line -> center(line, 48)).forEach(System.out::println);

    }

}