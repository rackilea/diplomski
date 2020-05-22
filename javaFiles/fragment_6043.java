public boolean setHeight(int newHeight) {
    if (1<=height && height<=10) {
        height = newHeight;
        return true;
    } else {
        return false;
    }
}