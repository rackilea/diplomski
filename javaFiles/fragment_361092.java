EditText paperText = findViewById(R.id.paper_text);
    paperText.addTextChangedListener(new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            String paper = paperText.getText().toString().trim();
            Toast.makeText(MainActivity.this, "" + paper, Toast.LENGTH_SHORT).show();
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    });