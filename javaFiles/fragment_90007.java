class CaseInsensitiveStringComparator extends FieldComparatorSource{

@Override
public FieldComparator<String> newComparator(String arg0, int arg1, int arg2,
        boolean arg3) throws IOException {
    return new CaseIgonreCompare(arg0, arg1);
}
}



class CaseIgonreCompare extends FieldComparator<String>{

private String field;
private String bottom;
private String topValue;
private BinaryDocValues cache;
private String[] values;

public CaseIgonreCompare(String field, int numHits) {
    this.field = field;
    this.values = new String[numHits];
}

@Override
public int compare(int arg0, int arg1) {
    return compareValues(values[arg0], values[arg1]);
}

@Override
public int compareBottom(int arg0) throws IOException {
    return compareValues(bottom, cache.get(arg0).utf8ToString());
}

@Override
public int compareTop(int arg0) throws IOException {
    return compareValues(topValue, cache.get(arg0).utf8ToString());
}

public int compareValues(String first, String second) {
    int val = first.length() - second.length();
    return val == 0 ? first.compareToIgnoreCase(second) : val;
};

@Override
public void copy(int arg0, int arg1) throws IOException {
   values[arg0] = cache.get(arg1).utf8ToString();
}

@Override
public void setBottom(int arg0) {
    this.bottom  = values[arg0];
}

@Override
public FieldComparator<String> setNextReader(AtomicReaderContext arg0)
        throws IOException {
    this.cache = FieldCache.DEFAULT.getTerms(arg0.reader(), 
            field  , true);
    return this;
}

@Override
public void setTopValue(String arg0) {
    this.topValue = arg0;
}

@Override
public String value(int arg0) {
    return values[arg0];
}