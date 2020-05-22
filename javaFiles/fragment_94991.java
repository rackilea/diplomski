@Test
public void addUserTestFails() {
    UserDAO userDAO = new UserDAOImpl(session);
    try {
        doThrow(new SQLGrammarException()).when(session).save(any());
        userDAO.addUser("testusername", "testpassword");
        verify(transaction, never()).commit();
    } catch (SQLGrammarException e) {
        verify(transaction).rollback();
    }
}