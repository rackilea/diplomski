public ClientDetails getClientDetails(String givenID) {
    boolean found = false;
    int index = 0;

    for(;index<aListOfClientDetails.size();index++){
        if((aListOfClientDetails.get(index).ClientID.equals(givenID))) {
            found = true;
            break;
        }
    }


    if(found)
        return aListOfClientDetails.get(index);
    else return null;

}