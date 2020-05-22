public void addListenerOnButton() {

    imageButton = (ImageButton) findViewById(R.id.imageButton);

    imageButton.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View arg0) {
            Intent i = new Intent(Project1.this,ImageFitScreen.class);
            startActivity(i);
        }

    });

}