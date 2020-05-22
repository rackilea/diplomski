et_search.addTextChangedListener(new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            String txt = et_search.getText().toString();
            adapter.filterList(txt);
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    });