TextWatcher watcher = new TextWatcher() {

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            //YOUR CODE
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            //YOUR CODE
        }

        @Override
        public void afterTextChanged(Editable s) {

                //YOUR CODE
        }
    };

    editIn.addTextChangedListener(watcher);
    editFt.addTextChangedListener(watcher);
    editYd.addTextChangedListener(watcher);