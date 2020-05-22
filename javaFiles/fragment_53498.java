public class IterateString {

    private static void printChar(int aChar) {
        System.out.println((char) (aChar));
    }

    public static void main(String[] args) {
        String str = "<BigBus><color>RED</color><number>123</number>........</BigBus>";

        str.chars()
                .forEach(IterateString::printChar);

        // other options
        System.out.println();
        str.chars()
            .mapToObj(ch -> (char) ch)
            .forEach(System.out::println);

        System.out.println();
        str.chars()
            .filter(Character::isDigit)
            .forEach(IterateString::printChar);
    }
}