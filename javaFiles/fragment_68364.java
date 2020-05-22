abstract class DmValue<T> {
    Class<T> cls;
    public DmValue(Class<T> cls) {
        this.cls = cls;
    }
    public Class<T> getValueType() {
        return this.cls;
    }
}