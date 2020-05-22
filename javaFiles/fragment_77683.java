public class Rts {
    public static void main(String[] args) {
        System.out.println(zorg(new RtsC()));
    }
    static int zorg(RtsA x) {
        return x.f()*10 + x.a;
    } 
}

abstract class RtsA {
  int a = 2;
  int f() { return a; }
}
class RtsB extends RtsA {
  int b = 3;
  int f() { return b; }
}
class RtsC extends RtsB {
  int c = 4;
}