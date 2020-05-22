import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonSerializeTest {

    /* main method to illustrate the problem */
    public static void main(String[] args) {
        Object[] identifiers= {12345678,"ITEM","abc.def.ghijkl.mnopqr",87654321};
        EntityUid uid = new EntityUid(identifiers);
        Gson converter = new GsonBuilder().create();
        String json = converter.toJson(uid);
        System.out.println("Converted to string: " + json);
        EntityUid uid2 = converter.fromJson(json, EntityUid.class); // ERROR
        System.out.println("Converted back to object: " + uid2);
    }

    /* the POJO that gets serialized and fails while deserializing */
    public static class EntityUid  {
        private final List<Object> identifier = new ArrayList<Object>();

        public EntityUid(final Object... identifier) {
            for (Object partialIdentifier : identifier) {
                this.identifier.add(partialIdentifier);
            }
        }

        @Override
        public String toString() {
            return "EntityUid [identifier=" + identifier + "]";
        }


    }
}