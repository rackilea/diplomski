notReg.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent loginIntent = new Intent(register.this, login.class);
            register.this.startActivity(loginIntent);
        }
    });