send_todata.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        name = editName.getText().toString();
        password = editPassword.getText().toString();

        new SendDataToServer().execute(name, password);
    }
});