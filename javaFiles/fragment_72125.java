editText.addTextChangedListener(new TextWatcher() {
        @Override
        public void afterTextChanged(Editable edt) {
            if (edt.length() == 1 && edt.toString().equals("0"))
                editText.setText("");
        }

        // ...
    });