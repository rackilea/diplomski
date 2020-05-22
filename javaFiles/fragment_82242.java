public E pop() {
E p = null;
if (!isEmpty()) {
    p = v.lastElement();
    v.remove(v.size() - 1);
}
return p;