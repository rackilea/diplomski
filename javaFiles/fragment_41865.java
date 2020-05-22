public class MyEditTextCell extends EditTextCell {
    @Override
    public void onBrowserEvent(Context context, Element parent, String value, NativeEvent event, ValueUpdater<String> valueUpdater) {
        if(value == null || value.isEmpty())
            super.onBrowserEvent(context, parent, value, event, valueUpdater);
    }
}