647 public static <T> boolean any(
648       Iterator<T> iterator, Predicate<? super T> predicate) {
649     checkNotNull(predicate);
650     while (iterator.hasNext()) {
651       T element = iterator.next();
652       if (predicate.apply(element)) {
653         return true;
654       }
655     }
656     return false;
657 }