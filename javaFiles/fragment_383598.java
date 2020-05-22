boolean append = false;
if (Character.getNumericValue(code.charAt(i)) == 0) {
    if (current.getLeft() == null) {
        append = true;
        i--;
    }
    else {
        current = current.getLeft();
        if (current.isLeaf()) {
            append = true;
        }
    }
}
// same for right side ...
if (append) {
    result += current.getWeight().getLetter();
    current = root;
}