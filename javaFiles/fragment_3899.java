public void myMethod() {
    int a = 1;
    Runnable r = new Runnable() {
        @Override
        public void run() {
            System.out.println("My effectively final variable has value: " + a);
        }
    };
}