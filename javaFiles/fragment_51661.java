import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class FilterTest {

    @Test
    public void testFilter() {
        // setup
        List<User> users = new ArrayList<>();
        users.add(new User("foo", "bar"));
        users.add(new Employee("baz", "bat", "supervisor"));
        users.add(new User("x", "y"));
        users.add(new Employee("alpha", "omega", "developer"));
        List<Employee> expected = new ArrayList<>();
        expected.add((Employee) users.get(1));
        expected.add((Employee) users.get(3));
        // exercise
        List<Employee> actual = Filter.getEmployeeList(users);
        // assert
        Assert.assertEquals(expected, actual);
    }
}