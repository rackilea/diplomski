@Test
public void testDoThat() {

    when(new SomeService()).doThat();

    then(caughtException()).isExactlyInstanceOf(GenericException.class);

}