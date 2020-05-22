class SomeClass {
    private MediaPlayer mp2 = null;

    private void whateverFunctionYouAreIn() {
        hubSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                SomeClass.this.mp2 = MediaPlayer.create(Textbox.this, R.raw.hero);
                SomeClass.this.mp2.start();
            }
            public void onNothingSelected(AdapterView<?> parentView) {}
        });

        //TODO: put this in an onClickListener:
        if (this.mp2 != null) {
            this.mp2.pause();
        }
    }
}