public static String abbreviateMiddle(String input, String middle, int length) {
    if (input != null && input.length() > length) {
        int half = (length - middle.length()) / 2;

        Pattern pattern = Pattern.compile(
                "^(.{" + half + ",}?)" + "\\b.*\\b" + "(.{" + half + ",}?)$");
        Matcher matcher = pattern.matcher(input);

        if (matcher.matches()) {
            return matcher.group(1) + middle + matcher.group(2);
        }
    }

    return input;
}