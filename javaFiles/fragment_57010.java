// define and instantiate button listener 
1)    final ButtonClick buttonClicked = new ButtonClick();
      // attach listener to button
2)    theButton.setOnClickListener(buttonClicked);

            <------ here you still didn't executed onClick :) 

      // trying get value 
3)    final int finalValue = buttonClicked.getValue(); // This still equals zero.