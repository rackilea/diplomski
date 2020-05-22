@Override
    public int compare(String a, String b) {
        Integer x = base.get(a);
        Integer y = base.get(b);
        if (x.equals(y)) {
            return a.compareTo(b);
        }
        return x.compareTo(y);
    }