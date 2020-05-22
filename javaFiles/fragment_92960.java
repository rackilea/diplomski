public static void main(final String[] args) {
    String[] myStringArray = { "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };
    String input = "Monday";
    String[] output = Arrays.stream(myStringArray).filter(e -> !e.equals(input)).toArray(String[]::new);
    System.out.println(Arrays.toString(output));
}