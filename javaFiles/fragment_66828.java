import scala.collection.immutable.*;

public class foo {
  public List test() {
    List nil = Nil$.MODULE$; // the empty list
    $colon$colon one = $colon$colon$.MODULE$.apply((Integer) 1, nil); // 1::nil
    $colon$colon two = $colon$colon$.MODULE$.apply((Integer) 2, one); // 2::1::nil
    System.out.println(one);
    System.out.println(two);
    return two;
  }
}