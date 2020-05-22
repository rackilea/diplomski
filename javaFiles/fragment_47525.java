package so28235867;

import com.google.common.collect.Lists;
import com.google.gson.Gson;
import lombok.Data;

import java.util.List;

public class Foo {

    public static void main(final String[] args) {
        final Root root = Root.of(Plaintext.of("List", Lists.newArrayList("1", "2", "3", "4")), new Value<String>("1"), new Value<Integer>(10));
        System.out.println(new Gson().toJson(root));
    }

    @Data(staticConstructor = "of")
    // TODO: tweak JSON serialisation to respect naming convention
    static class Root {
        private final Plaintext Plaintext;
        private final Value<String> SINGLE_FUNCTION;
        private final Value<Integer> IN_FLOW;
    }

    @Data(staticConstructor = "of")
    static class Plaintext {
        private final String type;
        private final List<String> value;
    }

    @Data
    static class Value<T> {
        private final T value;
    }
}