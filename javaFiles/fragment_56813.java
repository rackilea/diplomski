public void addConnection(User usr) {
    if (usr !=null) { 
        connections.add(usr);
        usr.getConnections().add(this); 
    }    
}