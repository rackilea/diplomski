checkedTextView.setOnClickListener(new View.OnClickListener(){

    private int a = 0; // Add this here

    @Override
    public void onClick(View v) {
        ...
        // int a = 0; // Remove this
        ...
        if (a == 3){
            try {
                Intent intent = new Intent(StartOfTheGame.this, SecondStageOfTheGame.class);
                startActivity(intent);
                finish();
            } catch (Exception e) {
            }
        }
    }
}