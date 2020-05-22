private boolean search(int val) {
    if (numberList != null && val >= 1 && val <= 50) {
        return Arrays.asList(numberList).contains(val);
    }
    return false;
}