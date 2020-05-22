public class DateFilter extends BaseOperation implements Filter {
    private String dateStr;
    public DateFilter(String dateStr) {
        this.dateStr = dateStr;
    }

    public boolean isRemove( FlowProcess flowProcess, FilterCall filterCall ) {
        // get the arguments TupleEntry
        TupleEntry arguments = filterCall.getArguments();

        // initialize the return result
        boolean isRemove = false;

        String inputStr = argument.getString("datefield1"); // Get the date from datefield1 field

        isRemove = compareDate(inputStr, dateStr);

        return isRemove;
    }

    private boolean compareDate(String inputStr, String dateStr) {
        // Add you logic to match the date. Try [joda](http://www.joda.org/joda-time/)
        return false;
    }
}