editText.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                   if (s.toString().length()<1){
                      button.setVisibility(View.GONE)
                   }else button.setVisibility(View.VISIBLE)
                }

                @Override
                public void afterTextChanged(Editable s) {

                }
            });