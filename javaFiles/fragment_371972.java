public Box getNthBox(Box box, int depth) {
    If (depth == 0) {
        return box;
    } 

    return getNthBox(box.getBox(), depth - 1);
}