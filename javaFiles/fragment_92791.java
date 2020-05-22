builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
    @Override
    public void onClick(DialogInterface dialog, int which) {
        numButtons = input.getText();

        int numOfButtons = Integer.parseInt(numButtons.toString());
        Button[] buttons = new Button[numOfButtons];

        for(int i = 0; i < numOfButtons; i++){
            buttons[i] = new Button(MainActivity.this);
            layout1.addView(buttons[i]);
        }
    }
});