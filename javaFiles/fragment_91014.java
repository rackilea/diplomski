private static final String ALLOWED_CHARACTERS = "ABCD...789";
private static final Random RNG = new Random();
public static String getID() {
    StringBuilder builder = new StringBuilder();
    while (builder.length() < DESIRED_LENGTH) {
        builder.append(ALLOWED_CHARACTERS.charAt((int)(RNG.nextDouble()*ALLOWED_CHARACTERS.length())));
    }
    return builder.toString();
}