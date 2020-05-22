showResultButton= (Button)findViewById(R.id.showResults);
showResultButton.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        processCutest(cutestCheckBoxDog, cutestCheckBoxCat, cutestCheckBoxParrot);

        Toast.makeText(getApplicationContext(),catCounter +  " " + dogCounter, Toast.LENGTH_LONG).show();