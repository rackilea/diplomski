public class IntMinMax extends LMinMax {

    public IntMinMax(int min, int max) {
        super(min, max);
    }

    @Override
    public Object execute(Object value, CsvContext context) {
        Long result = (Long) super.execute(value, context);
        return result.intValue();
    }

}