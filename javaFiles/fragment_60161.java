final String[] input = {"adasd|adsasd\\|adsadsadad|asdsad",
        "adasd|adsasd\\\\|adsadsadad|asdsad",
        "adasd|adsasd\\\\\\|adsadsadad|asdsad"};

final String regex = "(?<=[|]|^)[^|\\\\]*(?:\\\\.[^|\\\\]*)*";
final Pattern pattern = Pattern.compile(regex);
Matcher matcher;

for (String string: input) {
    matcher = pattern.matcher(string);
    System.out.println("\n*** Input: " + string);
    while (matcher.find()) {
        System.out.println(matcher.group(0));
    }
}