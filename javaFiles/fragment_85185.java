create.setOnClickListener(new View.OnClickListener() {
        @Override 
        public void onClick(View v) {

            pullerName = etPuller.getText().toString();
            storeName = spinner.getSelectedItem().toString();
            Intent i = new Intent(MainActivity.this,MainActivity2.class);
            i.putExtra("puller-name", pullerName);
            i.putExtra("store-name", storeName);
            startActivity(i);
        } 
    });