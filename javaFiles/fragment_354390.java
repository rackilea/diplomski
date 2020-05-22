List<String[]> csvBody = reader.readAll();
for (String[] strings : csvBody) {
    for (int i = 0; i < strings.length; i++) {
        strings[i] = strings[i].toUpperCase();
    }
}