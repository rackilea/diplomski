@Override
public void onStart(){
    super.onStart();
    Button button = (Button) findViewById(R.id.test_button);
    button.setOnClickListener(new View.OnClickListener() {

        public void onClick(View v) {
            Log.i(TAG, "Clicked");
        }
    });
    // This will NOT trigger the onClickListener!
    button.setPressed(true);
}