String[] strings = new String[] { "ab", "ac", "a", "abc" };
java.util.Arrays.sort(strings);

ListBox l = new ListBox();

for (String s : strings) {
    l.addItem(s);
}