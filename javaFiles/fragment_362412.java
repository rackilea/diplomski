editText.setOnFocusChangeListener(new OnFocusChangeListener() {          
        @Override
        public void onFocusChange(View v, boolean hasFocus) {
            if (hasFocus) {
               editText.getBackground().setColorFilter(color, PorterDuff.Mode.SRC_IN);
            }
            else{                   
               editText.getBackground().clearColorFilter();
            }
        }
    });