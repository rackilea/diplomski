public static void main(final String[] args) {
    ArrayList<String> list = new ArrayList<>();
    list.add("1");
    list.add("2");
    list.add("3");
    list.add("4");
    list.add("5");
    List<String> result = getCombinations(list, 2);
    System.out.println(result.size());
    System.out.println(result);
}

private static List<String> getCombinations(final List<String> list, final int length) {
    if (length >= 1) {
        return removeUntilLength(list, length, 0);
    }
    return new ArrayList<>();
}

private static List<String> removeUntilLength(final List<String> list, final int length, final int lastIdx) {
    List<String> ret = new ArrayList<>();
    if (list.size() == length) {
        ret.add(list.toString());
    } else {
        for (int i = lastIdx; i < list.size(); i++) {
            List<String> tmp = new ArrayList<>(list);
            tmp.remove(i);
            ret.addAll(removeUntilLength(tmp, length, Math.max(i, 0)));
        }
    }
    return ret;
}