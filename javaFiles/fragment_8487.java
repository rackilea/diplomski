ArraList<String> list=new ArrayList<String>();

EditText et = (EditText) findViewById(R.id.EditText01);

    et.addTextChangedListener( new TextWatcher()
    {
        @Override
        public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {

            try
            {
                char currentChar = arg0.charAt(arg1); // currently typed character
                list.add(currentChar);// Add the character to the list.
            }
            catch(Exception e)
            {
                // error
            }
        }

        @Override
        public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
                int arg3) {

        }

        @Override
        public void afterTextChanged(Editable arg0) {

        }
    });