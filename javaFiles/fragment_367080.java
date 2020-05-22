private OnClickListener okButtonListener = new OnClickListener() {

            public void onClick(View v) {
            Intent secondPageIntent = new Intent(getBaseContext(), SecondPage.class);
            secondPageIntent.putExtra("PASSVALUE","ANY  STRING HERE");
            startActivity(secondPageIntent);

            }
     };