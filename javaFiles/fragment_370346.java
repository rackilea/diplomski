hEditText.addTextChangedListener(new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2)
        {
          if(!charSequence.equals("")){
            Double hDouble = Double.parseDouble(charSequence.toString());
            Double bDouble = Double.parseDouble(charSequence.toString());
            Double mDouble = Double.parseDouble(charSequence.getText().toString());
            Double miDouble = Double.parseDouble(charSequence.getText().toString());

            lResult.setText("" + Math.sqrt((hDouble * hDouble) + (bDouble * bDouble)));
           }
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    });