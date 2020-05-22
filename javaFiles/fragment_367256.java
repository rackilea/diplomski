private static final Comparator<User> USER_COMPARATOR = new Comparator<User>() {
    @Override
    public int compare(User o1, User o2) {
        int value1 = o1.getPropertyCode().compareTo(o2.getPropertyCode());
        if (value1 == 0) {
            int value2=o1.getPropertyValue().compareTo(o2.getPropertyValue());
            return value2;
        }
        return value1;
    }
};
private void someCode() {
    Collections.sort(originalList, USER_COMPARATOR);
}