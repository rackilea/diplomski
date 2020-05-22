import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

public interface ListAbstractor {
    List<String> getList();
    void addTo(String s);

    public static ListAbstractor of(Supplier<List<String>> listSupplier,
                                    Consumer<String> adder) {
        return new ListAbstractor() {
            @Override
            public List<String> getList() {
                return listSupplier.get();
            }

            @Override
            public void addTo(String s) {
                adder.accept(s);
            }
        };
    }
}