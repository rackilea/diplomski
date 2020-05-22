public double addNumbers(String a, String b) {

    try {
        double i = Double.parseDouble(a);
        double j = Double.parseDouble(b);
        return i + j;
    } catch (NullPointerException cause) {
        throw new IllegalArgumentException(
            "Arguments aren't allowed to be null", cause);
    } catch (NumberFormatException cause) {
        throw new IllegalArgumentException(
            "One or more arguments weren't numbers", cause);
    }
}