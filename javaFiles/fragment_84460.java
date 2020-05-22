public interface Try<T> {

    <U> Try<U> flatMap(Function<T, Try<U>> f);

    class Success<T> implements Try<T> {
        public final T value;

        public Success(T value) {
            this.value = value;
        }

        @Override
        public <U> Try<U> flatMap(Function<T, Try<U>> f) {
            return f.apply(value);
        }
    }

    class Fail<T> implements Try<T> {
        // Alternatively use Exception or Throwable instead of String.
        public final String error;

        public Fail(String error) {
            this.error = error;
        }

        @Override
        public <U> Try<U> flatMap(Function<T, Try<U>> f) {
            return (Try<U>)this;
        }
    }
}