public static String replaceRandom(String input) {
    Pattern p = Pattern.compile("(?<=\\[)Random\\((\\d+),(\\d+)\\)(?=\\])");
    Matcher m = p.matcher(input);
    String output = input;
    if (m.find()) {
        int min = Integer.valueOf(m.group(1));
        int max = Integer.valueOf(m.group(2));
        int rand = min + (int)(Math.random() * ((max - min) + 1));
        output = output.substring(0, m.start()) +rand+ output.substring(m.end());
    }
    return output;
}

public static void main(String[] args) {
    System.out.println("(1,9): "
                        + replaceRandom("$.store.book[Random(1,9)].title"));
    System.out.println("(1,999): "
                        + replaceRandom("$.store.book[Random(1,999)].title"));
    System.out.println("(50,200): "
                        + replaceRandom("$.store.book[Random(50,200)].title"));
}