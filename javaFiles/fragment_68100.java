import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestClass   {
    public static void main(String[] args) {
    Y y = new Y();
    y.makeZ();
    Iterator<Object> it = X.list.iterator();
    while (it.hasNext())
        System.out.println(it.next());
    }   
}

class X { 
  public static List<Object> list = new ArrayList<Object>();
} 

class Y { 
void makeZ() { 
     Z xObject1 = new Z(10) ;
     Z xObject2 = new Z(11) ;
    } 
} 

class Z {
int a;
Z(int j) {
     // put Z into X's list
    a = j;
    X.list.add(this);
}
public String toString() {
    return a + "";
}
}