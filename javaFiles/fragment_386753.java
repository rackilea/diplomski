@Rule
public final ExpectedException exception = ExpectedException.none();

@Test
public void removeOneThrowsDataAccessException() {
    BookRepository mockedRepository = Mock(BookRepository.class);
    when(mockedRepository.get(1L)).thenThrow(new DataAccessException());

    BookService foo = new BookServiceImpl(mockedRepository);

    exception.expect(DataAccessException.class);

    foo.removeOne(1L);
}