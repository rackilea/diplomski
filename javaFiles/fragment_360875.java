Name.addTextChangedListener(new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String name = NamaAlat.getText().toString();
            if(name!=null){
                TextView output.setText(Name.getText().toString()+"-"+Spesicification.getText().toString()"-"+MoreOuput.getText().toString());
            }
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    });

    Spesification.addTextChangedListener(new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String spek = NamaAlat.getText().toString();
            if(spek!=null){
                TextView output.setText(Name.getText().toString()+"-"+Spesicification.getText().toString()"-"+MoreOuput.getText().toString());
            }
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    });