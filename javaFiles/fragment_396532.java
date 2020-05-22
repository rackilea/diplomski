public class MyNonSingleton implements ISomeInterface {

    public MyNonSingleton() {}

    @Override
    public int doSomething() {
        //create connection to database, write to a file, etc..
        return something;
    }

}