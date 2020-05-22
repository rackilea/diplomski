finishButton.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        for (int i = 0; i < 4; i++) {
            radioGroup[i].setBackgroundColor(Color.RED);
            for (int j = 0; j < 4; j++) {
                radioGroup[i].getChildAt(j).setBackgroundColor(Color.WHITE);
            }
        }
    }
});