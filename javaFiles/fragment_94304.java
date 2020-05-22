public ValidationException(String msg, 
                           Set<? extends ConstraintViolation<?>> violations) {
  super(msg);
  this.violations = Collections.unmodifiableSet(
      new HashSet<ConstraintViolation<?>>(violations));
}