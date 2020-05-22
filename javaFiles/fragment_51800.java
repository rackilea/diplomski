Iterator buttonIterator = seat.buttonList.iterator();
while (buttonIterator.hasNext()) {
    Object button = buttonIterator.next(); //or more specific type, if your list was generified
    if (button == null) { //or some other criteria, wrote this just as an example
        buttonIterator.remove();
    }
}