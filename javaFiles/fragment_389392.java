public class TrafficQueue {
    private Car [] carArray;
    private int numberOfcarsInQueue;

    public TrafficQueue(int numberOfcarsInQueue){
    carArray = new Car[numberOfcarsInQueue];

    }

    static class Car 
    {
        public String name;

        public Car(String name) {
            this.name = name;
        }
    }

    public void add(Car car){
    carArray[numberOfcarsInQueue] = car;
    numberOfcarsInQueue ++;

    }

    public static void main(String[] args) {

             TrafficQueue queueLane1 = new TrafficQueue(10);
             Car toyota = new Car("Toyota");
             queueLane1.add(toyota);
    }
}