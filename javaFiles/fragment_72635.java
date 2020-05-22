EditText tv_filter = (EditText) findViewById(R.id.filter);

TextWatcher fieldValidatorTextWatcher = new TextWatcher() {
        @Override
        public void afterTextChanged(Editable s) {
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if (filterLongEnough()) {
                populateList();
            }
        }

        private boolean filterLongEnough() {
            return tv_filter.getText().toString().trim().length() > 2;
        }
    };
    tv_filter.addTextChangedListener(fieldValidatorTextWatcher);