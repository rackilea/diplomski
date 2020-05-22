package test.mockito;

import static org.junit.Assert.fail;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class UserDAOImplTest {

    @Mock
    Session session;

    @Mock
    Transaction transaction;

    @Before
    public void setUp() {
        when(session.getTransaction()).thenReturn(transaction);
    }

    @Test
    public void addUserTest() {
        UserDAO userDAO = new UserDAOImpl(session);
        userDAO.addUser("testusername", "testpassword");
        try {
            verify(session).getTransaction();
            verify(session.getTransaction()).commit();
        } catch (SQLGrammarException e) {
            fail(e.getMessage());
        }
        verify(session).close();
    }
}