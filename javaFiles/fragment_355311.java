public class MyDateFormat extends DateFormat {

    @Override
    public StringBuffer format(Date date, StringBuffer toAppendTo, FieldPosition fieldPosition) {
        return toAppendTo.append(String.format("/Date(%d)/", date.getTime()));
    }

    @Override
    public Date parse(String source, ParsePosition pos) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Object clone() {
        return new MyDateFormat();
    }
}