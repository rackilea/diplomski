cardedittext.addTextChangedListener(new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
                                  if (s.length() >= 16) {

                expiry.setVisibility(View.VISIBLE);

            } else {
                expiry.setVisibility(View.GONE);

            }

        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    });