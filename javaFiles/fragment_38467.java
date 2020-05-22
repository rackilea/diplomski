String mode;

mode = "unknown";

try {
  java.lang.Object a;
  a = new java.lang.Object();
  mode = "JAVA";
}
  catch(Throwable e) {
  mode = "JS";
}