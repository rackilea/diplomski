public static final int RENAMED = 100;

btnOk.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
            Intent backToMain = new Intent(Options.this, MainActivity.class);      
            EditText labelName = (EditText) findViewById(R.id.set_name);
            String lblName = labelName.getText().toString();
            backToMain.putExtra(LABEL_NAME, lblName);
            isRenamed = true;
            setResult(RENAMED);
            finish();


        }
    });