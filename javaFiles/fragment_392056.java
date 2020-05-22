void Foo(String str) {
    class OneShotTask implements Runnable {
        String str;
        OneShotTask(String s) { str = s; }
        public void run() {
            someFunc(str);
        }
    }
    Thread t = new Thread(new OneShotTask(str));
    t.start();
}