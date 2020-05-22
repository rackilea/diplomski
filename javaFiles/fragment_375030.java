Iterable<String> scalaIterable = JavaConversions.asScalaIterable(lst);
scalaIterable.filter(...);
scalaIterable.drop(1);
scalaIterable.somethingMore(...);

Collection<String> backToJava = JavaConversions.asJavaCollection(scalaIterable);