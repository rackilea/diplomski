btn1.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
       String Str_Compare = value.getText().toString();
        if (Str_Compare.equals("+") || Str_Compare.equals("-")|| Str_Compare.equals("*")||      Str_Compare.toString().equals("/")){
            value.setText("");
        }
        value.append("1");
        result.append("1");
    }
});