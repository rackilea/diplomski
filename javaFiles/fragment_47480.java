class Main {
    private Cell<IntWrapper>[] cells;
    //...
    void updateCell(int index, int newValue) {
        cells[index].getValue().set(newValue);
    }
}