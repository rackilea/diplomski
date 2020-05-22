for (Iterator<String> iterator = list.iterator(); iterator.hasNext();) {
    String value = iterator.next();
    if (value.equals("B")) {
        iterator.remove();
    }
}