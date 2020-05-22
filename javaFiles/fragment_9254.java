class Cmp implements Comparator<String> {
    @Override
    public int compare(String a, String b) {
        return prefixNum(a) - prefixNum(b);
    }

    private int prefixNum(String a) {
        return Integer.parseInt(a.split("_")[0]);
    }
}