for (int j = i; j < splitted.length; j++) {
    if (splitted[j] != null && splitted[j].contains(word)) {//what if splitted[j] is null?
        splitted[j] = null;
        count++;
    }
}