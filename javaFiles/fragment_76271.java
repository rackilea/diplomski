import static java.util.Spliterators.spliterator;
import static java.util.stream.StreamSupport.stream;

import java.util.Comparator;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class FixedBatchSpliteratorWrapper<T> implements Spliterator<T> {
  private final Spliterator<T> spliterator;
  private final int batchSize;
  private final int characteristics;
  private long est;

  public FixedBatchSpliteratorWrapper(Spliterator<T> toWrap, long est, int batchSize) {
    final int c = toWrap.characteristics();
    this.characteristics = (c & SIZED) != 0 ? c | SUBSIZED : c;
    this.spliterator = toWrap;
    this.est = est;
    this.batchSize = batchSize;
  }
  public FixedBatchSpliteratorWrapper(Spliterator<T> toWrap, int batchSize) {
    this(toWrap, toWrap.estimateSize(), batchSize);
  }

  public static <T> Stream<T> toFixedBatchStream(Stream<T> in, int batchSize) {
    return stream(new FixedBatchSpliteratorWrapper<>(in.spliterator(), batchSize), true);
  }

  @Override public Spliterator<T> trySplit() {
    final HoldingConsumer<T> holder = new HoldingConsumer<>();
    if (!spliterator.tryAdvance(holder)) return null;
    final Object[] a = new Object[batchSize];
    int j = 0;
    do a[j] = holder.value; while (++j < batchSize && tryAdvance(holder));
    if (est != Long.MAX_VALUE) est -= j;
    return spliterator(a, 0, j, characteristics());
  }
  @Override public boolean tryAdvance(Consumer<? super T> action) {
    return spliterator.tryAdvance(action);
  }
  @Override public void forEachRemaining(Consumer<? super T> action) {
    spliterator.forEachRemaining(action);
  }
  @Override public Comparator<? super T> getComparator() {
    if (hasCharacteristics(SORTED)) return null;
    throw new IllegalStateException();
  }
  @Override public long estimateSize() { return est; }
  @Override public int characteristics() { return characteristics; }

  static final class HoldingConsumer<T> implements Consumer<T> {
    Object value;
    @Override public void accept(T value) { this.value = value; }
  }
}