import java.util.*;
public class GenericTest<C extends GenericTest.HasLongProperty> {
    static interface HasLongProperty {
        long someLongProperty();
    }
    public long convertToLong(Collection<C> es) {
        long a = 0;
        for(C sth : es)
            a += sth.someLongProperty();
        return a;
    }
}