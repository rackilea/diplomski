public void run () {
    B b = new B(this);
    b.run();
}

public class B {
   private A a;
   public B(A a) {
       this.a = a;
       a.changeTitle("Ha!");
  }
}