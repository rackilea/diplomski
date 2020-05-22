for(char letter = 'A'; letter <= 'Z';letter ++){
int letterID = getResources().getIdentifier(""+letter, "id", getPackageName());
TextView txtview = (TextView) getView().findViewById(letterID);
    txtview .setTextSize(20 * getResources().getDisplayMetrics().density);
    txtview .setText(letter);
    txtview .setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
            checkGuess(letter);
            txtview.setClickable(false);
            txtview.setAlpha((float) .1);
        }
    });
}