final EditText getInput = (EditText)findViewById(R.id.enter_key_one);

final EditText getInput_two = (EditText)findViewById(R.id.enter_key_two);
Button clickButton = (Button) findViewById(R.id.next_button);
clickButton.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        String newValue = getInput.getText().toString().trim();
        int input = Integer.parseInt(newValue);
        System.out.println("Your value is " +input);

getInput_two.setVisibility(View.VISIBLE);
getInput.setVisibility(View.GONE);

    }
});