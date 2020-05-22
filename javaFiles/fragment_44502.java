for (String[] row : spaces) {
    String valueToFind = row[index];
    String value = firstFile.get(valueToFind);
    if (value == nil) {
        value = secondFile.get(valueToFind);
    }
    if (value != nil) {
        row[index] = value;
    } else {
        System.out.println("Missing " + valueToFind);
    }
}