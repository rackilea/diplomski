StringBuilder builder = new StringBuilder();

for (int rolls = 0; rolls < 4 +temp; rolls++) {
    value = (int) (Math.random() * 4 + 1);
    //Test if numbers generated are correct
    // Create the text view
    TextView textView = new TextView(this);
    textView.setTextSize(40);
    builder.append(value + " ");
    textView.setText(builder.toString());

    // Set the text view as the activity layout
    setContentView(textView);
    //store generated numbers here
    System.out.println(value);
}