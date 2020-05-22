class MyClass extends Application{
    private static MyClass instance

    public MyClass() {
        instance=this
    }

    public synchronized static getInstance() {
        if(!instance) {
            Thread.start { 
            // Have to run in a thread because launch doesn't return
            Application.launch(MyClass.class)
        }
        while(!instance)
            Thread.sleep(100)
    }
    return instance
  ...
} // class