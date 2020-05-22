private final List data; private final Iterator iterator;

private List<IRecord> buffer;
private Iterator<IRecord> bufferIterator;

private IRecord currentValue;

private int pageCount;
private int pageRowNum;

private boolean useBuffer;
private int position;
private int counter;

public MultiPageReportDataSource(List<? extends IRecord> data, int pageRowNum, int pageCount) {
    this.data = data;
    this.iterator = this.data.iterator();
    this.buffer = new LinkedList<IRecord>();
    this.bufferIterator = this.buffer.iterator();
    this.pageRowNum = pageRowNum;
    this.pageCount = pageCount;
    this.counter = pageCount;
}

@Override
public boolean next() throws JRException {
    if (position > 0 && position % pageRowNum == 0) {
        counter--;
        if (counter == 0) {
            buffer.clear();
            useBuffer = false;
            counter = pageCount;
        } else {
            useBuffer = true;
            bufferIterator = buffer.iterator();
        }
        position = 0;
    }
    if (useBuffer) {
        if (bufferIterator.hasNext()) {
            currentValue = bufferIterator.next();
        }
    } else {
        if (iterator.hasNext()) {
            currentValue = iterator.next();
            buffer.add(currentValue);
        } else {
            return false;
        }
    }
    position++;
    return true;
}

@Override
public Object getFieldValue(JRField jrField) throws JRException {
    Field field = ReflectUtil.field(CashierReportEntity.class, jrField.getName());
    try {
        return ReflectUtil.accessible(field).get(currentValue);
    } catch (IllegalAccessException e) {
        throw new JRException(e);
    }
}