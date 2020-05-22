// surely you shouldn't actually be testing for string equality here?
if ( user.getUserStatus().toString().equals("3") ) {
    statusShape.setFill(Color.RED);
} else {
    // or whatever the default color is...
    statusShape.setFill(Color.BLUE);
}