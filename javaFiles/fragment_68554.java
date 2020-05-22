Button startButton = (Button) findViewById(R.id.start_button);
    if (startButton != null)
        startButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            startSecondFragment(); // start your fragment from MainActivity
        }
    });

// This method will be in charge of handling your second fragment
private void startSecondFragment() {
    FragmentManager manager = getFragmentManager();
    FragmentTransaction transaction = manager.beginTransaction();
    transaction.replace(R.id.real_quote_frag, quoteFragment, "Quote");
    transaction.addToBackStack(null);
    transaction.commit(); 
}