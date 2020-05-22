public void flip(List<String> items, int length, String prefix)
{
    if (prefix.length() == length) {
        items.add(prefix);
        return;
    }
    increments(items, length, prefix + 'C');
    increments(items, length, prefix + 'S');
}