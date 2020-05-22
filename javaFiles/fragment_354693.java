public boolean remove(E e) {
if (indexOf(e) >= 0) {
    remove(indexOf(e));
    return true;
} else {
    return false;
}}