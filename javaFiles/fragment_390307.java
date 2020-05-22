import java.util.*;
import javax.persistence.*;
import org.junit.*;
import play.test.*;
import models.*;

public class Parent1Test extends UnitTest {

    public Parent1 p;
    public Child1 c1;
    public Child1 c2;
    public Child1 c3;

    @Before
    public void setUp() {
        Fixtures.deleteAllModels();

        p = new Parent1();
        c1 = new Child1();
        c2 = new Child1();
        c3 = new Child1();
    }

    public void byAddingParentToChilds() {
        c1.parent = p;
        c2.parent = p;
        c3.parent = p;

        c1.save();
        c2.save();
        c3.save();
        p.refresh();
    }

    @Test
    public void testByAddingParentToChilds() {
        byAddingParentToChilds();
        assertEquals(p.id, c1.parent.id);
        assertEquals(3, Child1.count());
    }

    public void byAddingChildsToParent() {
        p.childs = new ArrayList<Child1>();
        p.childs.add(c1);
        p.childs.add(c2);
        p.childs.add(c3);
        p.save();
    }

    @Test
    public void testByAddingChildsToParent() {
        // By adding childs
        byAddingChildsToParent();

        c1.refresh();
        assertEquals(3, Child1.count());
        // This will be null, because you added the childs to the 
        // parent while the childs are the owning side of the 
        // relation.
        assertNull(c1.parent);
    }

    @Test
    public void testDeletingAfterAddingParentToChilds() {
        byAddingParentToChilds();
        p.delete();
        assertEquals(0, Parent1.count());
        assertEquals(0, Child1.count());
    }

    @Test
    public void testDeletingAfterAddingChildsToParent() {
        byAddingChildsToParent();
        p.delete();
        assertEquals(0, Parent1.count());
        assertEquals(0, Child1.count());
    }

    @Test(expected=PersistenceException.class)
    public void testDeleteAllAfterAddingParentToChilds() {
        byAddingParentToChilds();
        // The cascading doesn't work for deleteAll() so this line
        // will throw an exception because the child elements still
        // reference the parent.
        assertEquals(1, Parent1.deleteAll());
    }

    @Test
    public void testDeleteAllAfterAddingChildsToParent() {
        byAddingChildsToParent();
        assertEquals(1, Parent1.deleteAll());
        assertEquals(0, Parent1.count());
        // Again the cascading doesn't work for deleteAll()
        assertEquals(3, Child1.count());
    }

}