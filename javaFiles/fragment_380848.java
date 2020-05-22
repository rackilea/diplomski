@Test(expected=Exception.class)
public void myTest() {
    DataProvider badDataProvider = () -> new BadData(); // Returns faulty data

    Service service = new Service(badDataProvider, Utils.getConsumer());
    service.someMethod(); // boom!
}