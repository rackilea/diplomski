etMessage.addTextChangedListener(new TextWatcher() {

        @Override
        public void onTextChanged(CharSequence s, int start, int before,
                int count) {

        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count,
                int after) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            String myString = s.toString();
            Toast.makeText(getApplicationContext(), myString,
                    Toast.LENGTH_SHORT).show();
            if (myString.length() > 0)
                if (myString.charAt(myString.length() - 1) == 'o') {
                    etMessage.setText("Hello");
                }
        }
    });