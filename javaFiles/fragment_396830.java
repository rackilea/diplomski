public void set(String element, int position) {
    if (arrays[position].equals(element))
        return;

    String tmp = arrays[position];
    arrays[position] = element;

    for (int i = 0; i < arrays.length; i++) {
        if (arrays[i].equals(element) && i != position) {
            arrays[i] = tmp;
            return;
        }
    }
    add(tmp);
}