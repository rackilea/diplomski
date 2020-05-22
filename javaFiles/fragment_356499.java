saveEntry.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent data = new Intent();
            data.putExtra(EXTRA_USERNAME, usernameEditText.getText().toString());
            data.putExtra(EXTRA_HINT, hintEditText.getText().toString());
            data.putExtra(EXTRA_PASSWORD, passwordEditText.getText().toString());

            //You were missing these 2 lines
            int id  = getIntent().getIntExtra(EXTRA_ID, -1);
            if(id != -1){data.putExtra(EXTRA_ID, id);}

            setResult(RESULT_OK, data);
            finish();
        }
    });