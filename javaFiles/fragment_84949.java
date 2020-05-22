public Object[] Month() {
    List<String> Months = new ArrayList<>();
    if (chkJan.isSelected()) {
        Months.add("January");
    } else ...
    ...
    return new Object[]{Months};
}