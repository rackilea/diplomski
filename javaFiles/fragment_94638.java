public class ComboBoxWithSeparators() {
    @Override
    protected void setInternalValue(Object newValue) {
        Object oldValue = super.getValue();
        if(isSeparator(newValue))
            super.setInternalValue(oldValue);
        else
            super.setInternalValue(newValue);
    }
}