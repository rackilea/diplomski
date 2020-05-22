public class MySingleton {

    private static final MySingleton instance = new MySingleton();

    private MySingleton() { }

    public int doSomething() {
        //create connection to database, write to a file, etc..
        return something;
    }

    public static MySingleton getInstance() {
        return instance;
    }
}

public class OtherClass {

        public int myMethod() {
            //do some stuff
            int result = MySingleton.getInstance().doSomething();

            //do some other suff
            return something;
        }
}