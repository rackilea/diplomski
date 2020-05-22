private static final Pattern PATTERN = Pattern.compile("-m\\s*(?<number>[0-9]+)");

public static void main(String[] args)  {

    String test = "-m 5 -m444 -m 33 ";
    Matcher matcher = PATTERN.matcher(test);
    while(matcher.find()){
        System.out.println(matcher.group("number"));
    }

}