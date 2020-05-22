public static void main(String[] args) {
    String[] words = {"a", "the", "in", "if", "are", "it", "is"};
    List<String> wordList = new ArrayList<>(Arrays.asList(words));
    String[] tArray = {"a table is here", "books are sold", "if it is readable"};
    List<String> list = new ArrayList<>(Arrays.asList(tArray));

    for (int i = 0; i < list.size(); i++) {
        String[] tArrays = list.get(i).split(" ");
        List<String> line = new ArrayList<>(Arrays.asList(tArrays));
        for (String lineElement : line) {
            if (wordList.contains(lineElement)) {
                line.remove(lineElement);
            }
        }

        list.set(i, String.join(" ", line));
    }

    for (String string : list) {
        System.out.println(string);
    }
}