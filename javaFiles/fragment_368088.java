import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Test {
    public static void main(String[] ignored) {
        Tester t012 = new Ing2(new Ing1(new Ing0(new None())));
        System.out.println(t012.getDescription());

        Tester t210 = new Ing0(new Ing1(new Ing2(new None())));
        System.out.println(t210.getDescription());
    }
}

abstract class Tester {
    public List<String> getIngredients() {
        return Collections.emptyList();
    }

    public String getDescription() {
        StringBuilder sb = new StringBuilder();
        String sep = "";
        for (String s : getIngredients()) {
            sb.append(sep).append(s);
            sep=", ";
        }
        sb.append(".");
        return sb.toString();
    }
}

class None extends Tester {
}

class Ing0 extends Tester {
    private final Tester wrapped;
    Ing0(Tester wrapped) {
        this.wrapped = wrapped;
    }

    @Override
    public List<String> getIngredients() {
        List<String> list = new ArrayList<>(wrapped.getIngredients());
        list.add("ING -1");
        list.add("ING 0");
        return Collections.unmodifiableList(list);
    }
}

class Ing1 extends Tester {
    private final Tester wrapped;
    Ing1(Tester wrapped) {
        this.wrapped = wrapped;
    }

    @Override
    public List<String> getIngredients() {
        List<String> list = new ArrayList<>(wrapped.getIngredients());
        list.add("ING 1");
        return Collections.unmodifiableList(list);
    }
}

class Ing2 extends Tester {
    private final Tester wrapped;
    Ing2(Tester wrapped) {
        this.wrapped = wrapped;
    }

    @Override
    public List<String> getIngredients() {
        List<String> list = new ArrayList<>(wrapped.getIngredients());
        list.add("ING 2");
        return Collections.unmodifiableList(list);
    }
}