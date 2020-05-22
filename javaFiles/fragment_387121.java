public static String likeSanitize(String input) {
    return input
       .replace("!", "!!")
       .replace("%", "!%")
       .replace("_", "!_")
       .replace("[", "![");
}