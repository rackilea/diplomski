public static void main(String[] args) {

    List<MyClass> myThreads = new ArrayList<>();
    for (int i = 0; i < 2; i++) {
        MyClass myClass = new MyClass();
        Thread t = new Thread(myClass);
        t.start();
        myThreads.add(myClass);
    }
    Scanner in = new Scanner(System.in);
    in.next();

    for(MyClass t : myThreads){
        t.stop();
    }

}

class MyClass implements Runnable {

private Boolean flag;

public MyClass() {
    this.flag = true;
}

@Override
public void run() {
    while (flag) {  // <--- I do know that the "true" has to be changed to a Boolean
        try {
            System.out.println("Waiting 6 seconds!");
            Thread.sleep(6 * 1000);
            System.out.println("------------------------------------");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    System.out.println("Thread in program ended!");
}

public void stop(){
    this.flag = false;
} }