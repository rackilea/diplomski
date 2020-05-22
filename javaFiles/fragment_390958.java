EditText yourEditText = (EditText) findViewById(R.id.yourEditText);
yourEditText.setFilters(new InputFilter[] {
    new InputFilter() {
        @Override
        public CharSequence filter(CharSequence cs, int start,
                    int end, Spanned spanned, int dStart, int dEnd) {
            // TODO Auto-generated method stub
            if(cs.equals("")){ // for backspace
                 return cs;
            }
            if(cs.toString().matches("[a-zA-Z ]+")){
                 return cs;
            }
            return "";
        }
    }
});