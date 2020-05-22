import static java.lang.System.out;

public class AATester {
    public static void main(String[] args){

        //Test 1:
        for(int x: new int[]{ 0, 1, 2 } ){
            A w = getA(x);
            //I agree this is a nasty way to do it... but you CAN do it.
            Chain.a(w.setA("a1")).a(w instanceof C ? ((C) w).setC("c1") : null );
            out.println(w);
        }

        //Test for WAY 2: Hope this wins Paul Bellora's approval 
        //for conciseness, ease of use and syntactic sugar.
        C c = new C();
        //Invoke methods in any order with compile time type safety!
        c.setA("a2").a(c).setB("b2").a(c).set("C2");
        out.println(w);

        //Example 3, which is Example 1, but where the top level class IS known to be a "C"
        //but you don't have access to the source and can't add the "a" method to the 
        //top level class.  The method invocations don't have to be as nasty as Example 1.
        c = new C();
        Chain.a(c.setA("a3")).a(c.setB("b3")).a(c.setC("c3"));//Not much larger than Example 2.
        out.println(w);
    }
    public static getA(int a){//A factory method.
        A retval;//I don't like multiple returns.
        switch(a){
            case 0:  retval = new A(); break;
            case 1:  retval = new B(); break;
            default: retval = new C(); break;
        }
        return retval;
    }
}