1.  public class Tahiti {
2.      Tahiti u;
3.      public static void main(String[] args) {
4.          Tahiti t = new Tahiti(); // object A
5.          Tahiti t2 = t.go(t);
6.          t2 = null;
7.          // more code here
8.      }
9.      Tahiti go(Tahiti s) {
10.         Tahiti s1 = new Tahiti(); // object B
11.         Tahiti s2 = new Tahiti(); // object C
12.         s1.u = s2;
13.         s2.u = s1;
14.         s.u = s2;
15.         return s1;
16.     }
17. }