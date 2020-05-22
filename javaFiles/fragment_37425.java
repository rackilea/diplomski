String text = field.getText().toString();
if (!text.equals("")) {
    //Field has at least some text in it.
    try {
        float val = Float.parseFloat(text);
    }catch (NumberFormatException ex) {
    //Enterered text was not a float value, so you should do something
    // here to let the user know that their input was invalid and what you expect
    }

    //Do something with the value
}