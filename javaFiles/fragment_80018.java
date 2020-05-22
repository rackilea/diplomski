@Test
public void catchExceptionTest() {
    // given: an empty list
    List<Object> myList = new ArrayList<>();

    // when: we try to get the first element of the list
    // then: catch the exception if any is thrown
    catchException(myList).get(1);

    // then: we expect an IndexOutOfBoundsException
    Exception e = caughtException();
    // Use JUnit, TestNG, AssertJ etc. assertions on the "e" exception
    assert e instanceof IndexOutOfBoundsException;
}