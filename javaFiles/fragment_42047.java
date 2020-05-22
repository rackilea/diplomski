if(idx > -1) {
    String longDate = new SimpleDateFormat("MMMM").format(retrievedate);
    Integer current = numberOfPost.get(longDate);
    if (current == null) {
        current = 1;
    } else {
        current += 1;
    }
    numberOfPost.put(longDate, current);
}