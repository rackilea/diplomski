createEmail.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(musername.getText().toString().replaceAll("\\s+","")).append("@email.com");
            email = stringBuilder.toString();
            String semail=email;
            String str_username = musername.getText().toString();
            String str_fullname = musername.getText().toString();
            String str_password = mpassword.getText().toString();

            register(str_username,str_fullname, semail,str_password);
    });