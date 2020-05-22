boolean isDirty;
TextWatcher edittw = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {

            Toast.makeText(EditContact.this, "change detected", Toast.LENGTH_SHORT).show();
            isDirty = true;

        }
    };

    categoryname.addTextChangedListener(edittw);
    namename.addTextChangedListener(edittw);
    phonename.addTextChangedListener(edittw);
    addressname.addTextChangedListener(edittw);
    commentname.addTextChangedListener(edittw);