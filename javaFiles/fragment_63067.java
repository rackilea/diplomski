<com.google.android.material.textfield.TextInputEditText
   android:layout_width="match_parent"
   android:layout_height="wrap_content"
   android:hint="@string/my_hint"
   android:inputType="numberDecimal"
   android:text="@={obj.value}" />

@BindingAdapter("android:text")
public static void bindBigDecimalInText(EditText editText, BigDecimal oldValue, 
   BigDecimal newValue) {
    if (oldValue == null && newValue == null) {
        return;
    }

    if (oldValue != null && newValue != null && oldValue.equals(newValue)) {
        return;
    }

    editText.setText(amountToString(newValue));

    editText.setSelection(editText.getText().length());
}

@InverseBindingAdapter(attribute = "android:text")
public static BigDecimal getBigDecimalFromBinding(TextView view) {
    String string = view.getText().toString();

    return stringToAmount(string);
}