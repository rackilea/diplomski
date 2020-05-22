button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // Focus the field.
            editText.requestFocus();
            // Show soft keyboard for the user to enter the value.
            InputMethodManager im = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            im.showSoftInput(editText, InputMethodManager.SHOW_IMPLICIT);
        }
    });