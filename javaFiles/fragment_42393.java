editText.addTextChangedListener(new TextWatcher() {
        @Override
        public void onTextChanged(CharSequence s, int start, int before,
                int count) {
                         // do your stuffs here
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count,
                int after) {
        }

        @Override
        public void afterTextChanged(Editable s) {
            Log.e("TextWatcherTest", "afterTextChanged:\t" + s.toString());
        }
    });