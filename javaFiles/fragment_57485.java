import java.util.*;

public class TTT {
  public static void main(String[] argv) {
    LinkedList<Cookies> linkList = new LinkedList<>();
    linkList.add(new Cookies("Name1", 2, 2));
    linkList.add(new Cookies("Name2", 3, 1));
    linkList.add(new Cookies("Name3", 1, 6));
    linkList.add(new Cookies("Name4", 2, 2));
    linkList.add(new Cookies("Name2", 4, 2));

    for(int i=0; i<linkList.size(); i++ ) {
        Cookies c = linkList.get(i);
        if( c.getName().equals("Name2")) {
          System.out.println(c);
        }
    }
  }
}

class Cookies {
    String n;
    int a;
    int b;

    public Cookies(String n, int a, int b) {
      this.n = n;
      this.a = a;
      this.b = b;
    }

    public String getName() {
        return n;
    }

    public String toString() {
        return n+", " + a + ", " + b;
    }
}