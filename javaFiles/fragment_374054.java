String password = null;
edittext.setOnFocusChangeListener(new View.OnFocusChangeListener() {
    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        //First time edittext will be with default initialization so no tag will be set so u can check 
        if (!hasFocus){
            if (v.getTag() == null){
                //you require to put validations you want
                password = edittext.getText().toString();
                v.setTag("c");
                v.setText("");
                v.setHint("Confirm Password");
                v.requestFocus();
            }else if (((String)v.getTag()).equals("c"){
                //It is now confirm password field lost focus
            }
        }
    }
});