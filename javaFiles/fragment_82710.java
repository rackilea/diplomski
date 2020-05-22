String[] parts = string.split (" ");
Arrays.sort(parts, new Comparator<String>() {
    public int compare(String lhs, String rhs) {
        int res = Integer.compare(sumDigits(lhs), sumDigits(rhs));
        return res != 0 ? res : lhs.compareTo(rsh);
    }
    private int sumDigits(String chunk) {
        int res = 0;
        for ( int i = 0; i < chunk.length (); i++ ) {
            res += Integer.parseInt ( "" + chunk.charAt ( i ) );
        }
        return res;
    }
});