public class MyDate extends Date {
    DateFormat formatter = new SimpleDateFormat("MM/dd/yy");

    public String toString() {
        return this.formatter.format(this);
    }
}