for (int i = s.size() - 1; i >= 0; i--) {
    char c = s.get(i).charAt(s.get(i).length() - 1);
    if (c == 's') {
        s.remove(i);
    }

}