String[] buttons = new String[]{finalword,finaldummy1,finaldummy2};
        int first = random.nextInt(3);


        button1.setText(buttons[first]);
        button2.setText(buttons[Math.abs(first-1)]);
        button3.setText(buttons[Math.abs(first-2) + (first == 1 ? 1 : 0]);
        //the ? operator is a ternary operator
        //+ (first == 1 ? 1 : 0) translates to "if first is one, then add 1, if not, add 0