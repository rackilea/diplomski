public static String formatWords(String[] words) {
    if (words == null)
        return "";

    List<String> list = new ArrayList<>();

    for (String word : words) {
        word = word.trim();
        if (!word.isEmpty())
            list.add(word);
    }

    StringBuilder out = new StringBuilder();

    int len = list.size();

    for (int i = 0; i < len; i++) {
        out.append(list.get(i));
        if (i == len - 2)
            out.append(" and ");
        else if (i < len - 2)
            out.append(",");
    }

    return out.toString();
}

public static void main(String[] args) {
    String[] array = {"", "apples", "", "oranges", "", "melons", ""};
    System.out.println(formatWords(array));
}