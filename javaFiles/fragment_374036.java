ArrayList<Button> buttons = new ArrayList<>();

buttons.add((Button) findViewById(R.id.button1)); //Do this for all the buttons.

for(int i = 0; i < buttons.size(); i++){
    Button b = buttons.get(i);
    button1.setOnClickListener(new View.OnClickListener() {
    public void onClick(View v) {
        String number = String.valueOf(i);
        TextView  Insert_Number_1 = (TextView ) findViewById(R.id.editTextoutput);
        TextView Insert_Number_1_view = (TextView) findViewById(R.id.CurrentDisplay);
        Insert_Number_1.append(number_1);
        Insert_Number_1_view.append(number_1);

    }
});
}