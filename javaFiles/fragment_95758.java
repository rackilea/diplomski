List<String> values = new ArrayList<String>(25);
values.add("2013 7 23 20 59 25.5");
values.add("2000 12 7 0 2 -3.0");
values.add("2000 7 7 0 2 -4.0");

Collections.sort(values, new Comparator<String>() {
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy MM dd");
    @Override
    public int compare(String o1, String o2) {
        int result = -1;
        try {
            Date d1 = sdf.parse(o1);
            Date d2 = sdf.parse(o2);
            result = d1.compareTo(d2);
        } catch (ParseException exp) {
            exp.printStackTrace();
        }
        return result;
    }
});

for (String value : values) {
    System.out.println(value);
}