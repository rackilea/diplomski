TextWatcher watcher= new TextWatcher() {
        public void afterTextChanged(Editable s) { 
            if (TextBox1.getText().toString().equals("")) {
                 TextBox1.setBackgroundColor(getResources().getColor(android.R.color.white));
                 TextBox1.setTextColor(getResources().getColor(android.R.color.black));
            }

        }
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
              //Do something or nothing.                
        }
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            //Do something or nothing
        }
    };

    TextBox1.addTextChangedListener(watcher);