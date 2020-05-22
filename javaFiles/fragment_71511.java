ImageButton imgButton = (ImageButton) findViewById(R.id.imgButton);
imgButton.setImageBitmap(myBitmapObject);
imgButton.setOnClickListener(new View.OnClickListener(){    
     @Override
        public void onClick(View v) {
        Toast.makeText(yourActivity.this, "ImageButton Pressed", 
                       Toast.LENGTH_LONG).show();
         }
        });