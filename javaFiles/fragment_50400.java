import java.lang.reflection.*
import java.lang.annotation.*

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface A {}

class Annotated {
  @A def a() { "a" }
  @A def b() { "b" }
  def c() { "c" }
}

ann = new Annotated()

methods = ann.class.methods.findAll { it.getAnnotation(A) }

assert methods.size() == 2

assert methods.collect { it.invoke(ann) } == ["a", "b"]