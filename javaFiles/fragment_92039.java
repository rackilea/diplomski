import java.util.function.Predicate;
import java.util.function.BiPredicate;
import java.util.function.Supplier;
import java.util.function.Consumer;
import java.util.stream.IntStream;
import java.util.NoSuchElementException;

interface MyIterator<T> extends Iterator<T> {
  class Peekable<T> {
    private final MyIterator<T> iter;
    private T next = null;
    private boolean isNextBuffered = false;
    private boolean atEnd = false;

    private Peekable(MyIterator<T> iter) {
      this.iter = iter;
    }

    private void advance() {
      if(atEnd) throw new NoSuchElementException();
      if(iter.hasNext()) {
        next = iter.next();
        isNextBuffered = true;
      } else {
        atEnd = true;
      }
    }
    private boolean hasNext() {
      if(atEnd) return false;
      if(!isNextBuffered) advance();
      return !atEnd;
    }
    private T next() {
      T next = peek();
      advance();
      return next;
    }
    private T peek() {
      if(hasNext()) return next;
      throw new NoSuchElementException();
    }
  }

  static <T> MyIterator<T> of(BooleanSupplier hasNext, Supplier<T> next) {
    return new MyIterator<T>() {
      public boolean hasNext() {
        return hasNext.getAsBoolean();
      }
      public T next() {
        return next.get();
      }
    };
  }

  static <T> MyIterator<T> of(Iterator<T> iter) {
    return of(iter::hasNext, iter::next);
  }

  static MyIterator<Integer> range(int start, int end) {
    int[] value = {start};
    return of(() -> value[0] < end, () -> value[0]++);
  }

  default <R> MyIterator<R> map(Function<? super T,? extends R> mapper) {
    return of(this::hasNext, () -> mapper.apply(this.next()));
  }

  default MyIterator<T> filter(Predicate<? super T> predicate) {
    Peekable<T> iter = new Peekable<T>(this);

    return new MyIterator<T>() {
      public boolean hasNext() {
        while(iter.hasNext() && !predicate.test(iter.peek())) iter.advance();
        return iter.hasNext();
      }
      public T next() {
        hasNext();
        return iter.next();
      }
    };
  }

  default MyIterator<T> merge(MyIterator<T> other, BiPredicate<? super T,? super T> smallerEqual) {
    Peekable<T> iter1 = new Peekable<T>(this);
    Peekable<T> iter2 = new Peekable<T>(other);

    return of(() -> iter1.hasNext() || iter2.hasNext(),
              () -> {
                if(!iter1.hasNext()) return iter2.next();
                else if(!iter2.hasNext()) return iter1.next();
                else {
                  T elem1 = iter1.peek();
                  T elem2 = iter2.peek();
                  return smallerEqual.test(elem1, elem2) ? iter1.next() : iter2.next();
                }
              });
  }
}

interface MyIterable<T> extends Iterable<T> {
  default Iterator<T> iterator() {
    return myIterator();
  }

  MyIterator<T> myIterator();

  static <T> MyIterable<T> of(Supplier<MyIterator<T>> myIterator) {
    return new MyIterable<T>() {
      public MyIterator<T> myIterator() {
        return myIterator.get();
      }
    };
  }

  static <T> MyIterable<T> of(Iterable<T> iterable) {
    return of(() -> MyIterator.of(iterable.iterator()));
  }

  static MyIterable<Integer> range(int start, int end) {
    return of(() -> MyIterator.range(start, end));
  }

  default <R> MyIterable<R> map(Function<? super T,? extends R> mapper) {
    return of(() -> this.myIterator().map(mapper));
  }

  default MyIterable<T> filter(Predicate<? super T> predicate) {
    return of(() -> this.myIterator().filter(predicate));
  }

  default MyIterable<T> merge(MyIterable<T> other, BiPredicate<? super T,? super T> smallerEqual) {
    return of(() -> this.myIterator().merge(other.myIterator(), smallerEqual));
  }
}


public class Test {
  public static void main(String[] args) {
    MyIterable<Integer> iterable = MyIterable.range(0, 10);

    MyIterable<Integer> iter1 = iterable.map(x -> 2 * x).filter(x -> x < 10);
    MyIterable<Integer> iter2 = iterable.map(x -> 2 * x + 1).filter(x -> x < 10);
    MyIterable<Integer> iterMerged = iter1.merge(iter2, (x, y) -> x <= y);

    iter1.forEach(System.out::println);
    System.out.println();
    iter2.forEach(System.out::println);
    System.out.println();
    iterMerged.forEach(System.out::println);
  }
}