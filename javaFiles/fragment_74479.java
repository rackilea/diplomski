public String toStrings() {
    int i = list.size() - 1;
    String prova = new String();
    while ((i < list.size()) && (i >= 0)) {
        prova += list.get(i);
        i--;
    }
    return prova;
}