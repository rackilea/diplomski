//@ ensures size_ == null ==> \result == true;
public boolean sizeUndefined() {
    if (size_ == null)
        return true;

    return size_.length() > 0;
}