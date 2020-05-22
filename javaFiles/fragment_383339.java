} else if (cur == 'w') {
    if (count > 2) {
        throw new IllegalArgumentException("Too many pattern letters: " + cur);
    }
    appendInternal(new WeekFieldsPrinterParser('w', count));

...

static final class WeekFieldsPrinterParser implements DateTimePrinterParser {
    private final char letter;
    private final int count;

    public WeekFieldsPrinterParser(char letter, int count) {
        this.letter = letter;
        this.count = count;
    }

    @Override
    public boolean print(DateTimePrintContext context, StringBuilder buf) {
        WeekFields weekFields = WeekFields.of(context.getLocale());
        DateTimePrinterParser pp = evaluate(weekFields);
        return pp.print(context, buf);
    }