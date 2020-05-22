final Handler handler = new Handler();
    final Runnable runnable = new Runnable() {
        @Override
        public void run() {

            //Soap Call;
        }
    };

    editText.addTextChangedListener(new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {


        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

             handler.removeCallbacks(runnable);
        }

        @Override
        public void afterTextChanged(Editable s) {

            handler.postDelayed(runnable, 3000);

        }
    });