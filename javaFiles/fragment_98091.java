EditText1.setOnFocusChangeListener(new OnFocusChangeListener() {

                public void onFocusChange(View v, boolean hasFocus) {
                    if(hasFocus){
                        ((EditText) v).addTextChangedListener(new TextWatcher() {

                        public void onTextChanged(CharSequence s, int start, int before, int count) {
                             //

                        }

                        public void beforeTextChanged(CharSequence s, int start, int count,
                                int after) {
                            // 

                        }

                        public void afterTextChanged(Editable s) {
                            // affect EditText2

                        }
                    });

                }
                if(!hasFocus){
                    ((EditText) v).removeTextChangedListener();
                }
            }
        });

        }
    });