Collections.sort(list, new Comparator<String>() {
    public int compare(String a, String b) {
        return Integer.signum(fixString(a) - fixString(b));
    }
    private int fixString(String in) {
        return Integer.parseInt(in.substring(0, in.indexOf('_')));
    }
});