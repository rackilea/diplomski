private void createButtonDynamically() {
    LinearLayout layout = (LinearLayout) findViewById(R.id.linear_home);

    for (int i = 0; i < probleme.size(); i++) {
        Button myButton = new Button(this);
        myButton.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        myButton.setText(probleme.get(i));
        layout.addView(myButton);
    }
}