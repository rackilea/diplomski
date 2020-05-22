public class FetcherFactory {
        public <T> AbstractFetcher<T> make(Class<T> type) {
            if (type.equals(String.class)) {
                return (AbstractFetcher<T>) new StringFetcher();
            }
            else {
                return null;
            }
        }
    }