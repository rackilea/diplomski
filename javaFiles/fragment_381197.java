btnSaveRecord.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View arg0) {
            int id = databaseManager.addUser(new User(...));
            Toast toast = Toast.makeText(RegistrationActivity.this,"Welcome User #" + id,Toast.LENGTH_SHORT);
            toast.show();
        }
    });