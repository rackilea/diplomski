for(int i = 0; i < buttonList.size(); i++) {
    Button button = buttonList.get(i);
    button.setText("Question Details");

    final int j = i;

    button.setOnClickListener(new OnClickListener() {
        public void onClick(View arg0) {
            x = j;
            displayDetails();
        }
    });
}