while (parsing) {
    int event = xmlStreamReader.next();
    if (isEventPasswordAttribute(event)) {
        // create an Action to update password attribute,
        // passing in xmlStreamReader.getLocation() and other necessary parameters
    } else if (isTimeToAddNewUserNode(event)) {
        // create an Action to add new user
        // passing in xmlStreamReader.getLocation() and other necessary parameters
    }
} // end parse

...

for (Iterator<Action> it = actions.iterator(); it.hasNext(); ) {
    Action action = it.next();
    action.perform();
}