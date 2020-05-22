public class UserTest {
    @Test
    public void userValidParamsNoException() throws Exception {
        User user = new User("foo","bar",123);
        assertThat(user, is(not(nullValue())));
        assertThat(user.getFirstName(), is("foo"));
        assertThat(user.getLastName(), is("bar"));
        assertThat(user.getAge(), is(123));
    }

    @Test
    public void userLastNameNullNoException() throws Exception {
        User user = new User("foo",null, null);
        assertThat(user, is(not(nullValue())));
        assertThat(user.getFirstName(), is("foo"));
    }

    @Test(expected = ConstraintsViolatedException.class)
    public void userLastNameNotNullAgeNullThrowsException() throws Exception {
        User user = new User("foo","bar", null);
    }
}