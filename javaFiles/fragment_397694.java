//This has to be a global variable so that last clicked button can be retained. 
//Earlier when it was local to the listener so its value was always set to null whenever a button was clicked
private Button buttonClicked=null;

final OnClickListener clickListener = new OnClickListener() {

     public void onClick(View v) {
         Button button = (Button) v;
         button.getBackground().setColorFilter(new LightingColorFilter(0xFFFFFFFF, 0x003333));

         if (buttonClicked == null) {
                // first button is clicked
                buttonClicked = button;
         } 

//else if (buttonClicked.getParent() != button.getParent()) {//THIS was the culprit
 else if (buttonClicked != button) {//Direct comparison of buttons was the solution                    
// second button is clicked
 if (buttonClicked.getTag().equals(button.getTag())) {
        Toast.makeText(Spojnice.this, "Correct", Toast.LENGTH_SHORT).show();
        button.getBackground().setColorFilter(new LightingColorFilter(0xFFFFFFFF, 0x66FF33));
        buttonClicked.getBackground().setColorFilter(new LightingColorFilter(0xFFFFFFFF, 0x66FF33));
        buttonClicked.setEnabled(false);
        button.setEnabled(false);
        //Moved this line inside if condition so that button click is only set to null when there is a match.
        buttonClicked = null;
        } else {
                            Toast.makeText(Spojnice.this, "Wrong", Toast.LENGTH_SHORT).show();

                        /*
                        * IMPORTANT: change the color here to the original unclicked 
button color. Now in the else condition i.e. there was not a match we need to make the last clicked button to look like an unclicked button so we need to change it to original color and then make the new clicked button to be the current clicked button.
                            */
                            buttonClicked.getBackground().setColorFilter(new LightingColorFilter(0xFFFFFFFF, 0x66FF33));
                            //Make the second button the current cliked one
                            buttonClicked = button;

                    }

                }       
            }
     };