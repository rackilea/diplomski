TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() == 0) {
                    TextView.setText("empty");
                }
                else {
                    TextView.setText(charSequence);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        };
        EditText editText = (EditText) findViewById(R.id.editText);
        editText.addTextChangedListener(textWatcher);