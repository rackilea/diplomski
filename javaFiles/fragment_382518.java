public abstract class AbstractSetting<T> implements ISetting<T> {

    @Override
    public String getValueName() {
        Object obj = value();
        if (obj instanceof Boolean) {
            return ((Boolean) obj) ? "Yes" : "No";
        }
        return obj.toString();
    }

    @Override
    public boolean isHidden() {
        return false;
    }

    // etc.
}