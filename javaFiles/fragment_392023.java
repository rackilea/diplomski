public static boolean isObjectNullOrEmpty( final Object c ) {
  if (c == null) {
    return true;
  }

   if (c instanceof Collection<?>) {
     Collection<?> col = (Collection<?>)c;
     return col.isEmpty();
  }
   if (c instanceof Map<?, ?>) {
     Map<?, ?> map = (Map<?, ?>)c;
     return map.isEmpty();
  }
   return false;
}