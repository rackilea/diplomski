ArrayList<Button> buttons = new ArrayList<>();

buttons.add((Button) findViewById(R.id.button1)); //Do this for all the buttons.

for(Button b : buttons){
    b.setText("1"); //Do whatever you need to each button in here.
}