edittext = (EditText) findViewById(R.id.edtxt);
        edittext.setInputType(InputType.TYPE_CLASS_TEXT);
        edittext.addTextChangedListener(new TextWatcher() {

                @Override
                public void onTextChanged(final CharSequence s, int start, int before, int count) {             

                if (edittext.getText().length() < 3 ) {
                edittext.setInputType(InputType.TYPE_CLASS_TEXT);       
                }   
                else if (edittext.getText().length() == 3 ) {
                edittext.setInputType(InputType.TYPE_CLASS_NUMBER);
                }}
                @Override
                public void afterTextChanged(Editable s) {

                }
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }


    });}}