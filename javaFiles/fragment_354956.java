public class Cell {
    public int[] values;
    private boolean flag;

    public boolean isFlagged() {
        return flag;
    }

    public setFlag(boolean flag) {
        this.flag = flag;
    }
}