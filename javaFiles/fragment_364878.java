try {
    int appleInt = Integer.parseInt(apple.getText());
    int pearInt = Integer.parseInt(pear.getText());

    int result = appleInt + pearInt;

    // do something with result

} catch (NumberFormatException nfe) {
    // warn user that text is wrong
    // clear text fields
}