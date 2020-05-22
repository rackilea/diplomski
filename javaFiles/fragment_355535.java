import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;
import com.googlecode.objectify.*;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Parent;
import com.googlecode.objectify.util.Closeable;
import junit.framework.Assert;
import lombok.Getter;
import lombok.Setter;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

public class IdAllocationTest {
    @Entity
    public static class ChildEntity {
        @Parent
        @Getter
        @Setter
        private Ref<ParentEntity> parent;
        @Id
        @Getter
        @Setter
        private Long id;
    }

    @Entity
    public static class ParentEntity {
        @Id
        @Getter
        @Setter
        private Long id;
    }

    public static class OfyService {
        static {
            try {
                ObjectifyService.register(ChildEntity.class);
                ObjectifyService.register(ParentEntity.class);
            } catch (Exception e) {
                System.out.println("Could not initialized objectify service." + e.toString());
            }
        }

        public static Objectify ofy() {
            return ObjectifyService.ofy();
        }

        public static ObjectifyFactory factory() {
            return ObjectifyService.factory();
        }
    }

    private static LocalServiceTestHelper helper = new LocalServiceTestHelper(new LocalDatastoreServiceTestConfig());
    private static Closeable objectifyBegin;

    @BeforeClass
    public static void beforeClass(){
        helper.setUp();
        objectifyBegin = ObjectifyService.begin();
    }

    @AfterClass
    public static void afterClass(){
        objectifyBegin.close();
        helper.tearDown();
    }

    @Test
    public void testIdAllocation() {
        Ref<ParentEntity> parent1 = Ref.create(Key.create(ParentEntity.class, 1L));
        Ref<ParentEntity> parent2 = Ref.create(Key.create(ParentEntity.class, 2L));

        ChildEntity childEntity1 = new ChildEntity();
        childEntity1.setParent(parent1);
        childEntity1.setId(1L);

        ChildEntity childEntity2 = new ChildEntity();
        childEntity2.setParent(parent2);
        childEntity2.setId(1L);

        OfyService.ofy().save().entities(childEntity1, childEntity2).now();

        List<Key<ChildEntity>> keys = OfyService.ofy().load().type(ChildEntity.class).keys().list();
        // If overwriting occurred it would be only a single entity
        Assert.assertEquals(keys.size(), 2);
        for (Key<ChildEntity> child : keys) {

            System.out.println("Key( " +
                    "Key('" + child.getParent().getKind() + "'," + child.getParent().getId() + "), " +
                    "'" + child.getKind() + "', " + child.getId() + ")");
        }

        while(true) {
            KeyRange<ChildEntity> keyRangeParent1 = OfyService.factory().allocateIds(parent1, ChildEntity.class, 100);
            KeyRange<ChildEntity> keyRangeParent2 = OfyService.factory().allocateIds(parent2, ChildEntity.class, 100);

            for (Key<ChildEntity> keyParent1 : keyRangeParent1) {
                for (Key<ChildEntity> keyParent2 : keyRangeParent2) {
                    System.out.println(keyParent1.getId() + ", " + keyParent2.getId());
                    Assert.assertTrue(keyParent1.getId() != keyParent2.getId());
                }
            }
        }
    }
}