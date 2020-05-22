tv.addTextChangedListener(new TextWatcher()
    {
        private String current = "";
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count)
        {
            if(!s.toString().equals(current))
            {
                if(tv.getText().toString().trim().length()>0)
                {
                    tv.removeTextChangedListener(this);
                    String formated = tv.getText().toString().trim().replace("$", "");
                    current = formated;
                    tv.setText("$"+formated);
                    tv.setSelection(formated.length()+1);   

                    tv.addTextChangedListener(this);
                }
            }
        }

         @Override
         public void beforeTextChanged(CharSequence s, int start, int count, int after)
         {
         }
         @Override
         public void afterTextChanged(final Editable s)
         { 
         }
    });