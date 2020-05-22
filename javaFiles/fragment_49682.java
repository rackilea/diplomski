imageButton = (ImageButton) findViewById(R.id.imageButton);
    imageButton.setOnClickListener(new OnClickListener() {
        public void onClick(View v) {
             ImageButton aButton = (ImageButton)v;
             aButton.setImageResource(R.drawable.image1);
        }
});
imageButton.setImageResource(R.drawable.image2);