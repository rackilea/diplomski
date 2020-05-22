public class DataBaseLayerTest {

    @Test(expected = IncorrectPasswordException.class)
    public void testOpenSession_wrongUserNamePassword_returnsBadUserNamePassWordError() {
        SomeDBClass someDBClass = Mockito.mock(SomeDBClass.class)
        Mockito.when(someDBClass.connect(Mockito.anyString(), Mockito.anyString())).throw(new IncorrectPasswordException())

        DataBaseLayer underTest = new DataBaseLayer(someDBClass)

        underTest.runQuery(someQuery);
    }
}