list.removeIf("'xyz'"::equals);
/* or */
list.removeIf("'xyz'"::equalsIgnoreCase);
/* or */
list.removeIf("'xyz'"::startsWith);
/* or */
list.removeIf("'xyz'"::contains);
/* or */
list.removeIf("'xyz'"::endsWith);
/* or */
list.removeIf(Pattern.compile("'(xy?z)*'").asPredicate());
/* ...and so on... */