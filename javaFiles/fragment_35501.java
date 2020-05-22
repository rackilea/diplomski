//So after many attempts and much testing I found that all I had to do was add
 the submitOrder(view:null); in the onRadioButtonClicked method

// the following code is required in order for the radio groups to function 
//without causing an error

public void onRadioButtonClicked(View view) {
// Is the button now checked?
boolean checked = ((RadioButton) view).isChecked();
submitOrder(null);
}                

And for the checkboxes similarly we add the submitOrder(view:null); in 
the onCheckBoxClicked method which is called when the CheckBox is clicked

public void onCheckBoxClicked(View view) {
// Is the Checkbox now checked?
boolean checked = ((CheckBox) view).isChecked();
submitOrder(null);
}