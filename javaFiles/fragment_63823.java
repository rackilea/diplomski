private boolean search(int val) {
    if (numberList != null && val >= 1 && val <= 50) {
        for(int number : numberList) {
            if (number == val) {
                return true;
            }
        }
    }
    return false;
}