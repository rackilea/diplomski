public class Activate<D extends CanQuack & CanWalk> {
    private D d;

    Activate(D d) {
        this.d = d;
    }

    void doDuckLikeThings() {
        d.quack();
        d.walk();
        //d.swim(); //Doesn't work 
        //And shouldn't since that was the whole point of ISP.
    }
}

public class MainClass {
    public static void main(String[] args) {
       Activate<MyWaterFowl> a = new Activate<>(new MyWaterFowl());
       a.doDuckLikeThings();
    }
}