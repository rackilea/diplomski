CompoundButton.OnCheckedChangeListener onCheckedChangeListener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            if(b) {
                mainAdapter.setDiscount(Float.valueOf(compoundButton.getText().toString()));
            }
        }
    };
    rb1.setOnCheckedChangeListener(onCheckedChangeListener);
    rb2.setOnCheckedChangeListener(onCheckedChangeListener);
    rb3.setOnCheckedChangeListener(onCheckedChangeListener);