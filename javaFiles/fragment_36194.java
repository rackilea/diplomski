static <T> Stream<T> skipLastElements(Stream<T> s, int count) {
    if(count<=0) {
      if(count==0) return s;
      throw new IllegalArgumentException(count+" < 0");
    }
    ArrayDeque<T> pending=new ArrayDeque<T>(count+1);
    Spliterator<T> src=s.spliterator();
    return StreamSupport.stream(new Spliterator<T>() {
        public boolean tryAdvance(Consumer<? super T> action) {
            while(pending.size()<=count && src.tryAdvance(pending::add));
            if(pending.size()>count) {
              action.accept(pending.remove());
              return true;
            }
          return false;
        }
        public Spliterator<T> trySplit() {
            return null;
        }
        public long estimateSize() {
            return src.estimateSize()-count;
        }
        public int characteristics() {
            return src.characteristics();
        }
    }, false);
}
public static void main(String[] args) {
    skipLastElements(Stream.of("foo", "bar", "baz", "hello", "world"), 2)
    .forEach(System.out::println);
}