public class Observer implements IObserver {

    @Override
    public void notify(int i) {
        if(i % 1000 == 0){
            System.out.println("One thousand iterations elapsed.");
        }
    }

}