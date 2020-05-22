//Class constants
final static int INTEGER_SIZE = 3;
final static int DECIMAL_SIZE = 2;

public void buttonPressed(View v) {

    if (v.getId() == R.id.btn_dot){ // Handle dot
        if(!display.contains("."))
            display+=".";
    }else{ // Only number values reach this
        if(display.equals("0")){ // Handle default zero
            clear();
            updateScreen();
        }
        if(display.contains(".")){ //If the number contains a dot, decimal length has to be checked
            String[] split = display.split("\\.");
            if(split.length==2 && split[1].length()==DECIMAL_SIZE)
                return; // New number is not added
        }else if(display.length()==INTEGER_SIZE) //Otherwise check the length of the integer (whole sting)
            return; // New number is not added

        // New number will be added
        Button b = (Button) v;
        display += b.getText();
        updateScreen();

        DecimalFormat df = new DecimalFormat("##.##");
        df.setRoundingMode(RoundingMode.FLOOR);

        num1 = Double.parseDouble(display);
        textSubtractor.setText(df.format(num1));

        num2 = Double.parseDouble(textSubtractee.getText().toString());

        sub = num1 - num2;
        textResult.setText(df.format(sub));
    }

}