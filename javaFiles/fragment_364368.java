import java.util.LinkedHashMap;
import java.util.Map;

public class AliasToLinkedEntityMapTransformer extends
        AliasedTupleSubsetResultTransformer {

    @Override
    public Object transformTuple(Object[] tuple, String[] aliases) {
        Map<String, Object> result = new LinkedHashMap<>(tuple.length);

        for (int i = 0; i < tuple.length; i++) {
            String alias = aliases[i];

            if (alias != null) {
                result.put(alias, tuple[i]);
            }
        }
        return result;
    }

    @Override
    public boolean isTransformedValueATupleElement(String[] aliases,
            int tupleLength) {

        return false;
    }
}