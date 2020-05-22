public void testCreateBSucess() {
    A a = getInstanceOfA(); // Make sure "B" doesn't exists
    B b = a.createB("B");
    assertNotNull(b);
}

public void testCreateBFail() {
    A a = getInstanceOfA();
    a.createB("B"); // Making sure "B" exists
    B b = a.createB("B");
    assertNull(b);
}