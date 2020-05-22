String encipherButton = req.getParameter("encipherSubmit");
String decipherButton = req.getParameter("decipherSubmit");

if ( encipherButton != null && encipherButton.equals("Encipher") ) {

    // Do encipher operation

} else if ( decipherButton != null && decipherButton.equals("Decipher") ) {

    // Do decipher operation

} else {

    // Form was submitted without using the buttons.
    // Decide what you want to do in this case.
}