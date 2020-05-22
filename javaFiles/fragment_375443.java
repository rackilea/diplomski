public void testGuice() {
    PersonInterface pi = pf.create(new Address("boh"));
    IManager im = manF.getIManager(pi);

    System.out.println(im.getPersonName());
}