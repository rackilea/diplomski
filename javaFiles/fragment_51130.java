Iterator<String> stringIterator = result.iterator();
while (stringIterator.hasNext()) {
    String string = stringIterator.next();
    if (string.split("\\s").length != maxLength) {
        System.out.println(string);
        stringIterator.remove();
    }
}