class StringComparator implements Comparator<String> {

    @Override
    public int compare(String str1, String str2) {
        if (str1.equals(str2)) {
            return 0;
        } else if ("unassigned".equals(str1)) {
            return -1;
        } else if ("unassigned".equals(str2)) {
            return 1;
        }
        return str1.compareTo(str2);
    }
}