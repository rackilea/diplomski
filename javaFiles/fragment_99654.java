if(event.getSource() == enterBtn){

    if(pin.equals(userKeyString.toString()){

        // Correct pin

    } else {

        // Incorrect pin

    }

    userKeyString.setLength(0); // Clear the buffer for next input and validation

} else {

    userKeyString.append(event.getActionCommand());

}