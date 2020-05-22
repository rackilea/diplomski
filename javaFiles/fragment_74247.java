public void increments(List<String> items, int length, 
                       String prefix, char[] chars)
{
    if (prefix.length() == length) {
        items.add(prefix);
        return;
    }
    for (char c : chars)
        increments(items, length, prefix + c, chars);
}

List<String> inc = new LinkedList<>();
increments(inc, 4, "", new char[] {'C', 'S'});
for (String s : inc)
    System.out.println(s);