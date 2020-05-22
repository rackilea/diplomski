public class BigDecimalEditor extends PropertyEditorSupport {

private static Logger logger = Logger.getLogger(BigDecimalEditor.class);

@Override
public String getAsText() {
    String s = null;
    if (getValue() != null) {
        BigDecimal bd = (BigDecimal) getValue();
        DecimalFormat df = (DecimalFormat) NumberFormat.getInstance(Locale.GERMAN);
        df.setParseBigDecimal(true);
        s = df.format(bd);
    }
    return s;
}

@Override
public void setAsText(String text) throws IllegalArgumentException {
    DecimalFormat df = (DecimalFormat) NumberFormat.getInstance(Locale.GERMAN);
    df.setParseBigDecimal(true);
    BigDecimal bd = null;
    try {
        bd = (BigDecimal) df.parseObject(text);
    } catch (ParseException e) {
        logger.error("setAsText error", e);
        setValue(null);
    }
    setValue(bd);
}