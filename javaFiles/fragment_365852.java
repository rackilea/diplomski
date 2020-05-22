TextView TV;

TV = (TextView) rootView.findViewById(R.id.theID);

TV.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Toast.makeText(Verification.this, "New Input" , Toast.LENGTH_SHORT ).show();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

TV.setText(savedcode);