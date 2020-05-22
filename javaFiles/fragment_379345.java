@Test
public void test() {
    doInTransaction(session -> {
        List<CarFactory> carFactoryList = session.createQuery("from CarFactory").list();
        assertEquals(2, carFactoryList.size());
    });
}