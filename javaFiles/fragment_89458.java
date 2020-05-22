EditText etext = (EditText) view.findViewById(R.id.editTxt);

etext.addTextChangedListener(new TextWatcher() {

                                             @Override
                                             public void onTextChanged(CharSequence s,
                                                                       int start, int before,
                                                                       int count) {
                                                 //Set your boolean here to true
                                             }

                                             @Override
                                             public void beforeTextChanged(CharSequence s,
                                                                           int start, int count,
                                                                           int after) {
                                             }

                                             @Override
                                             public void afterTextChanged(Editable s) {
                                             }
                                         }

    );