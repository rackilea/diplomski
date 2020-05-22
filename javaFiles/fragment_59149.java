import scala.collection.JavaConverters;

java.util.List<Integer> javaList = new java.util.ArrayList<Integer>();
javaList.add(3);
javaList.add(2);
javaList.add(1);
scala.collection.immutable.List<Integer> scalaList = JavaConverters.collectionAsScalaIterable(javaList).toList();