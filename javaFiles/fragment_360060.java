public class A extends B {

}

public class B {

    public class thing {

    }

    private thing mything = new thing();
    public thing getThing(){
      return mything;
    }

}

public class C extends JFrame {
      A a = new A();
      Object thing = a.getThing();
}