Class<?> leftClass;
if( left instanceof Class) {
  leftClass = (Class)left;
}
else {
  leftClass = left.getClass();
}

//or in one line:
Class<?> leftClass = left instanceof Class ? (Class)left : left.getClass();

//do the same for right