package one;
public class X {
    protected void abby() {
    }
}

package other;
import one.X;
public class Y extends X {
    public void callAbbyOf(Y anyOther) {
        anyOther.abby();
    }
}