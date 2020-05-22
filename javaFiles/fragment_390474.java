b1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent data = new Intent();
            data.putExtra("n1", display.getText().toString());
            dat.putExtra("n2", disp.getText().toString());
            setResult(RESULT_OK, dat);

            finish();

        }
    });