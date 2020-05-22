@Test
public void registerNewFoo_fooAddedToList()
{
    Bar bar = new Bar(m_mockFooList);
    bar.registerNewFoo("test id");

    new Verifications() {{ m_mockFooList.addNewFoo((Foo) withNotNull()); }};
}