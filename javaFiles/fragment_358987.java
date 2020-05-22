// put your button text integers in ascending order in an array
int[] integersInAscendingOrder =  {buttonText1, buttonText2, buttonText3, buttonText4};

int i = 0;

// for each button's on click listener do something like the following:
button.setOnClickListener(new OnClickListener() {
    @Override
    public void onClick(View v) {
        int value = Integer.parseInt(button.getText().toString());
        checkOrder(value);
    }
});

// have a function check order pressed
private void checkOrder(int value) {
    // see if the button pressed is the right one
    if (value == integersInAscendingOrder[i]) {
        if (i == 3) {
            // insert code to run once all buttons pressed in right order
        } else {
            // insert code (if any) where less than all buttons pushed but in right order
            // increase i
            i++; 
        }
    } else {
        // button out of order
        Toast.makeText(this, "Wrong order", Toast.LENGTH_LONG).show()
    }
}