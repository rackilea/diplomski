/** returns a {@code List} containing two {@code Stream}s */
public static <T> List<Stream<T>> fork(Stream<T> source) {
    Spliterator<T> srcSp=source.spliterator();
    ArrayDeque<T> deque=new ArrayDeque<>();
    Boolean[] ahead={ null };
    final class Branch extends Spliterators.AbstractSpliterator<T> {
        private final Boolean type;
        Branch(Boolean b) {
            super(srcSp.estimateSize(), srcSp.characteristics());
            type=b;
        }
        public boolean tryAdvance(Consumer<? super T> action) {
            if(deque.isEmpty() || ahead[0]==type) {
                if(!srcSp.tryAdvance(deque::push)) return false;
                ahead[0]=type;
                action.accept(deque.peek());
                return true;
            }
            action.accept(deque.removeLast());
            return true;
        }
    }
    return Arrays.asList(
        StreamSupport.stream(new Branch(true),  false),
        StreamSupport.stream(new Branch(false), false));
}
public static <T> Stream<T> applyUntil(
        Stream<T> in, Function<Stream<T>,Stream<T>> func, Predicate<Stream<T>> predicate) {
    List<Stream<T>> fork = fork(in);
    return predicate.test(fork.get(0))? fork.get(1):
        applyUntil(func.apply(fork.get(1)), func, predicate);
}