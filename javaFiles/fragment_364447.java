/**
 * Check if 'v' is an EditText
 */
private static boolean isEditText(View v) {
    return v instanceof EditText;
}


/**
 * Set selectAllOnFocus(true) for all EditTexts in picker.
 */
private static boolean setTimePickerAutoSelectAll(TimePicker picker) {
    for(View view : picker.getTouchables()) {
        if(isEditText(view)) {
            EditText editText = (EditText) view;
            editText.setSelectAllOnFocus(true);
        }
    }
}