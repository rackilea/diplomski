$ javap -cp ~/scala-2.13.0/lib/scala-library.jar scala.jdk.javaapi.CollectionConverters
Compiled from "CollectionConverters.scala"
public final class scala.jdk.javaapi.CollectionConverters {
  public static scala.collection.mutable.Map<java.lang.String, java.lang.String> asScala(java.util.Properties);
  public static <A, B> scala.collection.mutable.Map<A, B> asScala(java.util.Dictionary<A, B>);
  public static <A, B> scala.collection.concurrent.Map<A, B> asScala(java.util.concurrent.ConcurrentMap<A, B>);
  public static <A, B> scala.collection.mutable.Map<A, B> asScala(java.util.Map<A, B>);
  public static <A> scala.collection.mutable.Set<A> asScala(java.util.Set<A>);
  public static <A> scala.collection.mutable.Buffer<A> asScala(java.util.List<A>);
  public static <A> scala.collection.Iterable<A> asScala(java.util.Collection<A>);
  public static <A> scala.collection.Iterable<A> asScala(java.lang.Iterable<A>);
  public static <A> scala.collection.Iterator<A> asScala(java.util.Enumeration<A>);
  public static <A> scala.collection.Iterator<A> asScala(java.util.Iterator<A>);
  public static <K, V> java.util.concurrent.ConcurrentMap<K, V> asJava(scala.collection.concurrent.Map<K, V>);
  public static <K, V> java.util.Map<K, V> asJava(scala.collection.Map<K, V>);
  public static <K, V> java.util.Dictionary<K, V> asJavaDictionary(scala.collection.mutable.Map<K, V>);
  public static <K, V> java.util.Map<K, V> asJava(scala.collection.mutable.Map<K, V>);
  public static <A> java.util.Set<A> asJava(scala.collection.Set<A>);
  public static <A> java.util.Set<A> asJava(scala.collection.mutable.Set<A>);
  public static <A> java.util.List<A> asJava(scala.collection.Seq<A>);
  public static <A> java.util.List<A> asJava(scala.collection.mutable.Seq<A>);
  public static <A> java.util.List<A> asJava(scala.collection.mutable.Buffer<A>);
  public static <A> java.util.Collection<A> asJavaCollection(scala.collection.Iterable<A>);
  public static <A> java.lang.Iterable<A> asJava(scala.collection.Iterable<A>);
  public static <A> java.util.Enumeration<A> asJavaEnumeration(scala.collection.Iterator<A>);
  public static <A> java.util.Iterator<A> asJava(scala.collection.Iterator<A>);
}