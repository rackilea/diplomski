String dv = null;
if (value.getText() != null) {
    dv = value.getText().toString ();
}
if(position == 0 && dv != null){

        v1 = Double.parseDouble(dv);
        mTextView.setText(Double.toString(answer));
}