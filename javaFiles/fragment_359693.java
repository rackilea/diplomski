// declare getObject() to possibly return null
@Nullable Object getObject() { ... }

void myMethod() {
   @Nullable Object o = getObject();
   // FindBugs issues no warning about calling toString on a possibly-null reference!
   o.toString();
}