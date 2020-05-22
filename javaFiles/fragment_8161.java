class DateComparator implements Comparator<String>, Serializable {

    public int compare(String date1, String date2) {
        int date1Int = convertDateToInteger(date1);
        int date2Int = convertDateToInteger(date2);

        return date1Int - date2Int;
    }

    // converts date string with format MM/DD/YYYY to integer of value YYYYMMDD
    private int convertDateToInteger(String date) {
        String[] tokens = date.split("/");

        return Integer.parseInt(tokens[2] + tokens[0] + tokens[1]);
    }
}

TreeMap<String, Integer> treeMap = new TreeMap<>(new DateComparator());