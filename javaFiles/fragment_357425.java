String REGEX = "^\\s+something\\s+(not\\s+)?else\\s+((((\\d+|\\d+-\\d+),\\s+)*)(\\d+|\\d+-\\d+))$";
Pattern PATTERN = Pattern.compile(REGEX);
Matcher matcher = PATTERN.matcher(" something else 1, 3, 4, 5-7");
if (matcher.matches()) {
    System.out
            .println(Arrays.toString(matcher.group(2).split(",\\s+")));
}