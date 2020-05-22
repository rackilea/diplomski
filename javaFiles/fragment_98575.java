inputSearch.addTextChangedListener(new TextWatcher() {

            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
               // I changed here to call filter method from Adapter class.
               String text =inputSearch.getText().toString().toLowerCase(Locale.getDefault());
                listadaptor.filter(text);
            }

            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
                    int arg3) {
                // TODO Auto-generated method stub

            }

            public void afterTextChanged(Editable arg0) {
                // TODO Auto-generated method stub                          
            }
        });