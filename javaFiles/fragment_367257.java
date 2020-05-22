Collections.sort(originalList, (o1, o2) -> {
    int value1 = o1.getPropertyCode().compareTo(o2.getPropertyCode());
    if (value1 == 0) {
        int value2=o1.getPropertyValue().compareTo(o2.getPropertyValue());
        return value2;
    }
    return value1;
});