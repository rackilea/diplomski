goButton.setOnClickListener(new OnClickListener() {
    public void onClick(View view) {
        String buttonPressed = (String) ((Button) view).getText();
        adapter.setButtonPressed(buttonPressed);
    }
});