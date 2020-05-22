public static void main(String[] args) {
    String yourString = "Location[fused 20.01234,-30.9876 acc=20 ";

    Pattern pattern = Pattern.compile("fused\\s(-?\\d+\\.\\d+),(-?\\d+\\.\\d+)\\s");
    Matcher matcher = pattern.matcher(yourString);
    if(matcher.find()) {
        String coordinate1 = matcher.group(1);
        String coordinate2 = matcher.group(2);
        System.out.println(coordinate1);
        System.out.println(coordinate2);
    }
}