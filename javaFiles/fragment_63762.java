import java.util.*;
public class GenericTest {
    static interface HasLongProperty {
        long someLongProperty();
    }
    public <C extends GenericTest.HasLongProperty> long convertToLong(Collection<C> es) {
        long a = 0;
        for(C sth : es)
            a += sth.someLongProperty();
        return a;
    }
}