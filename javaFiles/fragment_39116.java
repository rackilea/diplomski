public static List<SomeEnum> getRange(int init, int end) {
    List<SomeEnum> results = new ArrayList<SomeEnum>();
    if (!(init > end || init < 0 || end >= SomeEnum.values().length) {
        for (int i = init, i <= end; i++) {
            results.add(SomeEnum.values()[i]);
        }
    }
    return results;
}