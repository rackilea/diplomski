public class CellRangeAddress extends CellAddress {

    private CellAddress start;
    private CellAddress end;

    public CellRangeAddress(final CellAddress start, final CellAddress end) {
        super(start);
        this.start = start;
        this.end = end;
    }


    @Override
    public String formatAsString() {
        if (end != null) {
            return start.formatAsString() + ":" + end.formatAsString();
        }
        return super.formatAsString();
    }
}