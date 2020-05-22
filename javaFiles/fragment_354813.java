class Main {
    public static void main(String[]args) throws Exception {
        AutoCloseable _close = getCloseable()
       try (AutoCloseable close = _close) {
           // ...
       }

    }

    public static AutoCloseable getCloseable() {
        return new MyCloseable();
    }
}

class MyCloseable implements AutoCloseable {

    @Override
    public void close() {
        System.out.println("Closing");
    }
}