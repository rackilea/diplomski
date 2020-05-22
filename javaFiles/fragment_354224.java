public final class ExpirationDate extends Date {
    private final SimpleDateFormat formatter;

    public ExpirationDate(Date origin) {
        super(origin.getTime());
        this.formatter = new SimpleDateFormat("yyyy-MM-dd");
    }

    @Override
    public final String toString() {
        return formatter.format(this);
    }
}