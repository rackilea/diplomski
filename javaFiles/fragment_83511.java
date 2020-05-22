editText.addTextChangedListener(new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            int[] result = SmsMessage.calculateLength(s, false);
            textViewCounter.setText("" + result[2] + "/" + result[0]);
            messageCount = result[0];
            Log.i("TAG", "Characters: " + result[1] + "/" + (result[1] + result[2]));
            Log.i("TAG", "Number of SMS's: " + result[0]);
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    });