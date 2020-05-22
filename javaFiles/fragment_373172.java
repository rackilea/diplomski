if (value instanceof Comparable<?>) { // <-- notice <?>
  // Declare local var and cast it here
  // You will incur warning, but it's localized to this one instance only
  //
  // Also not that this cast is safe as it matches the signature of Comparable
  // in Java 1.4
  @SuppressWarnings( "unchecked" )
  Comparable<Object> comp = (Comparable<Object>)value;

  // Now you can use compareTo
  isMatch = (comp.compareTo(selectedValue) == 0);
} else {
  //fallback to equals
  isMatch = selectedValue.equals(value);
}