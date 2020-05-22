public static void main(String[] args) {
    String input = "removeProduct";

    //split into words
    String[] words = input.split("(?=[A-Z])");

    words[0] = capitalizeFirstLetter(words[0]);

    //join
    StringBuilder builder = new StringBuilder();
    for ( String s : words ) {
        builder.append(s).append(" ");
    }

    System.out.println(builder.toString());

}

private static String capitalizeFirstLetter(String in) {
    return in.substring(0, 1).toUpperCase() + in.substring(1);
}