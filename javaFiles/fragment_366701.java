public abstract class Abs {
private static final int DEFALUT_SIZE = 1000;
private static final int DEFALUT_DELAY = 1000;

private int size = DEFAULT_SIZE;
private int delay = DEFAULT_DELAY;

public void setSize(int size) { this.size = size; }
public int getSize() { return size; }
public void setDelay(int delay) { this.delay = delay; }
public int getDelay() { return delay; }
}