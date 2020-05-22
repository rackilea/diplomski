public class NumberValidator {
    public static final String INT_REGEX = "[^-?0-9]+";
    public static final String CONTAINS_INT_REGEX = "^.*[-?0-9]+.*$";

    public static int parseIntSafelyWithCatch(String value) {
        if (value == null || value.isEmpty()) {
            return -1;
        }
        try {
            return Integer.parseInt(value.trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public static int parseIntSafelyWithExtraction(String value) {
        if (value == null || value.isEmpty()) {
            return -1;
        }
        if (value.matches(CONTAINS_INT_REGEX)) {
            return Integer.parseInt(value.replaceAll(INT_REGEX, ""));
        }

        return -1;
    }

    public static boolean isValidNumber(int value) {
        return value != -1;
    }

    public static void main(String[] args) {
        System.out.println(parseIntSafelyWithCatch("")); // -1
        System.out.println(parseIntSafelyWithCatch("42")); // 42
        System.out.println(parseIntSafelyWithCatch(" 42")); // 42
        System.out.println(parseIntSafelyWithCatch(" 42 ")); // 42
        System.out.println(parseIntSafelyWithCatch("-42")); // -42
    }
}