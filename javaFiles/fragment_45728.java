@Editor.Ignore
@UiField
DateBox dateField;

LeafValueEditor<Long> longField = new LeafValueEditor<Long>() {
    @Override
    public Long getValue() {
        Date date = dateField.getValue();
        return date == null ? null : date.getTime();
    }
    @Override
    public void setValue(Long value) {
        Date date = value == null ? null : new Date(value.longValue());
        dateField.setValue(date);
    }
}