private String[] defaultValues =  {
    "a", "ab", "abc", "abcd", "abcde", "abcdef", "absdefg", "abcdefgh",
    "abcdefghi", "abcdefghij", "abcdefghijk", "abcdefghijkl", "abcdefghijklm",
};

public void filterModel(DefaultListModel<String> model, String filter) {
    for (String s : defaultValues) {
        if (!s.startsWith(filter)) {
            if (model.contains(s)) {
                model.removeElement(s);
            }
        } else {
            if (!model.contains(s)) {
                model.addElement(s);
            }
        }
    }
}