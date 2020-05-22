@Override
    public void onClick(View view) {
        showProgressDialog(etInput.getText().toString());
        tvTampil.setText(etInput.getText().toString());
        anjay = tvTampil.getText().toString();
    }