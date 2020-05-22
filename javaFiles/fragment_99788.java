for(User u1 : l1) {
    boolean unique = true;
    for(User u2: l2) { 
        if(u1.getUserEnteredValue().equals(u2.getValueReturnedFromDatabase())) {
            unique = false;
            break;
        }
    } 
    if(unique){
        l3.add(u1);
    }
}