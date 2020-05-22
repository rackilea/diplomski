editTextCost3.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    mItems.get(getAdapterPosition()).setmCost(editTextCost3.getText().toString());
                    if (mListener != null) {
                      mListener.onChange(mItems);
                    }
                }

                @Override
                public void afterTextChanged(Editable s) {

                }
            });