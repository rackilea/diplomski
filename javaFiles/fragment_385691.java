public class First<T extends Second, U extends First<T, U>> {
    Third<T, U> c;

    void test() {
        c.acceptParameterOfTypeA(this);
    }

}

class Second {

}

public class Third<X extends Second, Y extends First<X, Y>> {
    void acceptParameterOfTypeA(Y a) {

    }
}