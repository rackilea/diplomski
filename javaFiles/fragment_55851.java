private int getTotal() {
    ParseQuery<ParseObject> query = ParseQuery.getQuery("Money");
    try {
        int total = 0;
        List<ParseObject> objects = query.find();
        for (ParseObject p : objects) {
            total += p.getInt("value");
        }
        return total;
    } catch (ParseException e) {
        e.printStackTrace();
    }
    return -1;
}