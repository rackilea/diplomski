public class HelloWorld {
    public void getWorld() {
        this.setListener(new MyListenerInterface(){
            @Override
            public void innerMethod() {
                getWorld();
            }
            void getWorld(int i){}
        });
    }
}