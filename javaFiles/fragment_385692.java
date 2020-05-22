abstract class First<T extends Second, U extends First<T, U>> {
    Third<T, U> c;

    void test() {
        c.acceptParameterOfTypeA(getU());
    }

    abstract U getU();

}