public void checkUsers(Constraint constraint) {
    for(int i=0; i<nodeUsers().size(); i++) {
        UserElement elem = nodeUsers().getUsersElementAt(i);
        constraint.apply(elem);
    }
}