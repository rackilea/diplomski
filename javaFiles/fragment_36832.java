import gabrielkunkel.User; // <-- I had to import the class
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserTest {

    private User benny;

    @Before
    public void setUp() {
        benny = new User("benny", "long", 46, 'M');
    }


    @Test
    public void getFirstNameReturnsName() {
        assertEquals("We should receive the correct name", "benny", benny.getFirstName());
    }
}