public static List<Float> testIt() {
    List<Float> al = new ArrayList<Float>();
    al.add(1.0f);
    return al;
}

public static void main(String[] args) {
    List<?> al = testIt();
    for (int i = 0; i < al.size(); i++) {
        Object o = al.get(i);
        Double v = (Double) o;
        System.out.println(v);
    }
}