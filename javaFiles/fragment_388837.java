@RunWith(PowerMockRunner.class)
@SuppressStaticInitializationFor("test.Shelf")
public class HobbyUtilTest {

    @Test
    public void testShareReadContext() throws Exception {

        Book book = Mockito.mock(Book.class);
        Mockito.when(book.getContext(Mockito.anyInt())).thenReturn("context for test");

        Shelf shelf = Mockito.mock(Shelf.class);
        Mockito.when(shelf.getBook()).thenReturn(book);

        PowerMockito.mockStatic(Shelf.class);
        PowerMockito.when(Shelf.getInstance()).thenReturn(shelf);

        String context = HobbyUtil.shareReadContext(1);
        Assert.assertEquals("context for test", context);
    }
}