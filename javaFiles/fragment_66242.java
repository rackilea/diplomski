final EditText editText = (EditText) findViewById(R.id.editText2);

editText.addTextChangedListener(new TextWatcher() {
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count,
                int after) {
        }

        @Override
        public void afterTextChanged(Editable s) {
          if(s.toString().equals("tata")) {
             //do stuff
          }
        }
    });