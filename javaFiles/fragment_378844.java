import mockit.*;

import org.junit.Assert;
import org.junit.Test;


class BaseService {
    public int save() {
        validate();
        return 2;
    }

    public static int save2() {
        return 5;
    }

    public void validate() {
        System.out.println("base service save executing...");
    }
}

class ChildService extends BaseService {
    public int save() {
        System.out.println("child service save executing...");
        int x = super.save2();
        int y = super.save();
        System.out.println("super.save returned " + y);
        load();
        return 1 + y;
    }

    public void load() {
        System.out.println("child service load executing...");
    }
}

@MockClass(realClass = BaseService.class)
class MockBase {

    @Mock
    public int save() {
        System.out.println("mocked base");
        return 9;
    }
}

public class PreventSuperInvocation {

    @Test
    public void testSave() throws Exception {
        MockBase mockBase = new MockBase();
        Mockit.setUpMock(BaseService.class, mockBase);

        ChildService childService = new ChildService();
//      int x = childService.save();

        Assert.assertEquals(9 + 1, childService.save());

        Mockit.tearDownMocks();
    }

}