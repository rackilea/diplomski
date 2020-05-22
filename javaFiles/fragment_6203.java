@Test
public void updateWith() {
  User user = this.user.clone().setId(100);
  User mock = Mockito.spy(user);
  mock.updateWith(user);
  Mockito.verify(mock).doUpdateWith(user);
}