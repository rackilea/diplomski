public class StaySameFieldVisitor extends DocumentStoredFieldVisitor {
@Override
public void intField(FieldInfo fieldInfo, int value) {
    getDocument().add(new IntField(fieldInfo.name, value, Store.YES));
}

@Override
public void longField(FieldInfo fieldInfo, long value) {
    getDocument().add(new LongField(fieldInfo.name, value, Store.YES));
}

@Override
public void doubleField(FieldInfo fieldInfo, double value) {
    getDocument().add(new DoubleField(fieldInfo.name, value, Store.YES));
}

@Override
public void floatField(FieldInfo fieldInfo, float value) {
    getDocument().add(new FloatField(fieldInfo.name, value, Store.YES));
}