interface ItemWithId {
    abstract int getItemId();
}
class ItemA implements ItemWithId {
    int id;
    ItemA(int i) {
        id = i;
    }
    public int getItemId() {
        return id;
    }
}
class ItemB implements ItemWithId {
    int id;
    ItemB(int i) {
        id = i;
    }
    public int getItemId() {
        return id;
    }
}