import static org.junit.Assert.assertEquals;

import org.easymock.EasyMock;
import org.junit.Test;

public class ClassToTestTest {

    @Test
    public void thatGetIdCallsExpectedMockMethods() {
        final User user = new User();
        final Stuff userStuff = new Stuff();

        final Service mockService = EasyMock.createMock(Service.class);
        final StuffGetter mockStuffGetter = EasyMock.createMock(StuffGetter.class);

        EasyMock.expect( mockService.get(15) ).andReturn( user );
        EasyMock.expect( mockStuffGetter.getStuff(15) ).andReturn( userStuff );
        EasyMock.replay( mockService, mockStuffGetter );

        final ClassToTest classToTest = new ClassToTest( mockService, mockStuffGetter );
        final User returnedUser = classToTest.getUser(15);
        assertEquals(returnedUser, user);
        assertEquals(returnedUser.stuff, userStuff);

        EasyMock.verify( mockService, mockStuffGetter );
    }
}