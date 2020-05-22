//et and sk are class variables
et=(EditText)findViewById(R.id.editText);
sk = (SeekBar)findViewById(R.id.seekBar);

et.addTextChangedListener(new TextWatcher() {
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        try{
            //Update Seekbar value after entering a number
            sk.setProgress(Integer.parseInt(s.toString()));
        } catch(Exception ex) {}
    }
});