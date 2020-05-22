EditText editbox = (EditText)findViewById(R.id.editText1);
editbox.addTextChangedListener(new TextWatcher(){

        @Override
        public void afterTextChanged(Editable s){

            if(s.toString().length() > 0 && s.toString().charAt(0) != '$'){
                StringBuilder b = new StringBuilder(s.toString());
                b = b.reverse();
                b.append('$');
                b = b.reverse();
                editbox.setText(b);
                editbox.setSelection(editbox.getText().length());
            }



            int counter = 0;
            for (int i = 0; i < s.toString().length(); i++) {
                if (s.toString().charAt(i) == '$') {
                    counter++;
                }
            }
            if (counter > 1) {
                String str = s.toString().replace("$", "").trim();
                str = str.replaceAll("\\s+", "");
                StringBuilder b = new StringBuilder(str);
                b = b.reverse();
                b.append('$');
                b = b.reverse();
                edit.setText(b);
                edit.setSelection(edit.getText().length());
            } else {

                int spaceCount = 0;

                for (int i = 0; i < s.toString().length(); i++) {
                    if (s.toString().charAt(i) == ' ') {
                        spaceCount++;
                    }
                }
                if (spaceCount > 0) {
                    String str = s.toString().replace("$", "").trim();
                    str = str.replaceAll("\\s+", "");
                    StringBuilder b = new StringBuilder(str);
                    edit.setText(b);
                    edit.setSelection(edit.getText().length());
                }
            }


        }
    });