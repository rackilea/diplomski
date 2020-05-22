EditText textview = (EditText) findViewById(R.id.text_view);

textview.addTextChangedListener(new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
             //Called after before changed
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            //Called after on changed
        }

        @Override
        public void afterTextChanged(Editable s) {
            //Called after text changed
        }
    });