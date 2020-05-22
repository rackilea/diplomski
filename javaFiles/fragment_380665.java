import java.util.List;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.PredicateUtils;
import com.google.common.collect.Lists;

public class Test {
    public static void main(String[] args) {
        List<Integer> l = Lists.newArrayList(1, 2, 3, null, 7, null, 8, null);
        CollectionUtils.filter(l, PredicateUtils.notNullPredicate());
        System.out.println(l);
    }
}