public class ResultHolder {
    private Result value;
    public ResultHolder(Result initial) { value = initial; }
    public void setValue(Result newValue) { value = newValue; }
    public Result getValue() { return value; }
}