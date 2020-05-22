public boolean remove(E e) {
final int index = indexOf(e);
if (index >= 0) {
    remove(index);
    return true;
} else {
    return false;
}}