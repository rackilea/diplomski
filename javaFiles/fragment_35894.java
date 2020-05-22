btnSave.setOnClickListener(new View.OnClickListener() {

    @Override
    public void onClick(View arg0) {
        String name = txtName.getText().toString();
        String price = txtPrice.getText().toString();
        String description = txtDesc.getText().toString();
        new SaveProductDetails().execute(name, price, description);
    }
});