public ClientDetails getClientDetails(String givenID) {
    boolean found = false;
    int index = 0;
    ClientDetails details = null;

    for (ClientDetails check : aListOfClientDetails) {
        if(check.ClientID.equals(givenID)) {
            details = check;
            break;
        }
    }

    return details;
}