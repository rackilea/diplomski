class FireWhenAttachBooleanProperty extends SimpleBooleanProperty
{
    @Override
    public void addListener(ChangeListener<? super Boolean> listener)
    {
        super.addListener(listener);
        listener.changed(this, null, getValue());
    }
}