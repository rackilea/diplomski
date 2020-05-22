public interface NumberModel {
    public int getValue();
    public void setValue(int value);

    public void addChangeListener(ChangeListener listener);
    public void removeChangeListener(ChangeListener listener);
}