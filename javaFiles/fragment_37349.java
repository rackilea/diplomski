boolean found = false;
    for (int i = 0; i <= splitted.length-3 && !found; i += 4) {
        if(SportSpinner.getSelectedItem().toString().equals(splited[i]) && (UserSpinner.getSelectedItem().toString().equals(splited[i+1])) && (password.getText().toString().equals(splited[i+3])) && (email.getText().toString().equals(splited[i+2]))) {
        found = true;

        // Your open method goes here
        }
    }
    if (!found) {
    // Now put all the code from the previous else statement here, since it has now searched the whole list for the one set of inputs
    }