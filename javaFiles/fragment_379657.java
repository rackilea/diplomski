public static void main(String[] args) {
    process("Australia India# Amer$ca America@! America1");
}
public static void process(String rawData) {
    Pattern pattern = Pattern.compile("\\p{Alpha}*\\p{Punct}?\\p{Alpha}*");
    for (String s : rawData.split(" ")) {
        System.out.println("My Data Elements: " + s);
        if (pattern.matcher(s).matches()) {
            System.out.println("Allowed");
        } else {
            System.out.println("Not allowed");
        }
    }
}