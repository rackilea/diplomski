receiverName.addTextChangedListener(new TextWatcher() 
    {
        @Override
        public void onTextChanged(CharSequence paramCharSequence, int paramInt1,int paramInt2, int paramInt3) 
        {
            if((start + count) > 0)
            { entry01.setHint("20 lettres max"); }

            //if(entry01.getText().toString().equals(""));
          //  entry01.setHint("20 lettres max");
        }

        @Override
        public void beforeTextChanged(CharSequence paramCharSequence,int paramInt1, int paramInt2, int paramInt3) {}

        @Override
        public void afterTextChanged(Editable paramEditable) {}
    });