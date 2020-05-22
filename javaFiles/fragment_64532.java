class MainClass {
    public static void main(String[] args) {
        List<B> objects=new ArrayList<>();
            while(true){
             objects.add(new B());
            }
        }
}       

class B implements Runnable {           
    @Override
    public void run() {         
        //do nothing
    }
}