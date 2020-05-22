public static String helper(String help) {
    help = help.toLowerCase();
    help = help.replaceAll("\\s+", "");
    help = help.replaceAll("\\p{Punct}", "");
    return help;
}