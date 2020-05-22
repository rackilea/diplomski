//interface
public interface I1 <A> {
public void display1();
}

//class
public class c11<A> implements I1<A> {
A x;
public c11(A obj){
  x=obj;  
}

@Override
public void display1() {
    System.out.println(x + " is of type " + x.getClass());
}
}

// and calling code
int x = 5;     
c11<Integer> s1 = new c11<Integer>(x);
s1.display1();