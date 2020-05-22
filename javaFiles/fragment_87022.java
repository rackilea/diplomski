enum ValueType { INT, DOUBLE, FLOAT };

static abstract class ParsedValue<T>
{
    private final T data;
    private final ValueType type;

    public ParsedValue(T val, ValueType t)
    {
        data = val;
        type = t;
    }

    public ValueType getType()
    {
        return type;
    }

    public T getValue()
    {
        return data;
    }
}

static class IntParsedValue extends ParsedValue<Integer>
{
    public IntParsedValue(Integer val)
    {
        super(val, ValueType.INT);
    }
}

static class DoubleParsedValue extends ParsedValue<Double>
{
    public DoubleParsedValue(Double val)
    {
        super(val, ValueType.DOUBLE);
    }
}


public static void main(String[] args)
{
    List<ParsedValue<?>> lst = new ArrayList<>();

    Random rnd = new Random();

    for (int i = 0; i < 25; ++i) {
        ParsedValue<?> pv;            
        if (rnd.nextInt(2) == 0) {
            pv = new IntParsedValue(rnd.nextInt(500));
        }
        else {
            pv = new DoubleParsedValue(rnd.nextDouble());
        }

        lst.add(pv);
    }

    for (ParsedValue<?> pv : lst) {
        switch (pv.getType()) {
        case INT:
            System.out.println("Integer: " + pv.getValue());
            break;

        case DOUBLE:
            System.out.println("Double: " + pv.getValue());
            break;

        case FLOAT:
            //...
            break;
        }


    }

}