@Rule ExpectedException thrown = ExpectedException.none()

@Test
public void call2_should_throw_a_WantedException__not_call1() {
    // expectations
    thrown.expect(WantedException.class);
    thrown.expectMessage("boom");

    // init tested
    tested.call1(); // may throw a WantedException

    // call to be actually tested
    tested.call2(); // the call that is supposed to raise an exception
}