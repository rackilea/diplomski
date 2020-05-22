AHolder ah = AHolder.getInstance();
if(!ah.hasA("A1") ) {
    ah.addA("A1",new A());
}
if(!ah.hasA("A2") ) {
    ah.addA("A2",new A());
}
A a1 = ah.getA("A1");
A a2 = ah.getA("A2");