private static <T extends Component> GenericTypeMatcher<T> getMatcher(final Class<T> clazz) {
   return new GenericTypeMatcher<T>(clazz) {
      @Override
      protected boolean isMatching(final T object) {
         return ...
      }
   }
}