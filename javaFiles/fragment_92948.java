private Property.ValueChangeListener fileUploadedListener;

private ImageEnhancedFieldFactory(Property.ValueChangeListener fileUploadedListener) {
    this.fileUploadedListener = fileUploadedListener;
}

@Override
public <T extends Field> T createField(Class<?> type, Class<T> fieldType) {
    if (byte[].class.equals(type)) {
        UploadField uploadField = new UploadField(UploadField.StorageMode.MEMORY);
        uploadField.setFieldType(UploadField.FieldType.BYTE_ARRAY);
        uploadField.setButtonCaption("Change image");
        uploadField.addListener(fileUploadedListener);
        return (T) uploadField;
    }
    return super.createField(type, fieldType);
}