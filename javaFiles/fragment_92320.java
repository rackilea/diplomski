private boolean isSubsetOf(Collection<String> subset, Collection<String> superset) {
  for (String string : subset) {
     if (!superset.contains(string)) {
         return false;
     }
  }
  return true;
}