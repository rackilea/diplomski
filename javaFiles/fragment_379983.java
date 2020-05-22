public class AntiRecusionList<E> extends ArrayList<E> {


private final ThreadLocal<IdentityHashMap<AntiRecusionList<E>, ?>> fToStringChecker =
        new ThreadLocal<IdentityHashMap<AntiRecusionList<E>, ?>>() {
            @Override
            protected IdentityHashMap<AntiRecusionList<E>, ?> initialValue() {
                return new IdentityHashMap<>();
            }
        };    

@Override
public String toString() {
    boolean entry = fToStringChecker.get().size() == 0;
    try {
        if (fToStringChecker.get().containsKey(this)/* test if "this" has been seen before */) {
            return "{skipping recursion}";
        } else {
            fToStringChecker.get().put(this, null);
            entry = true;
        }
        return super.toString();
    } finally {
        if (entry)
            fToStringChecker.get().clear();
    }
}
}