class Task implements Runnable{
String name;


public Task(String name) {
    super();
    this.name = name;
}


@Override
public void run() {
    System.out.println("Job "+this.name+" Started");
    long k=1;
    for(int i=0;i<=Integer.MAX_VALUE/1.5;i++){
        k = k +k;
    }

    System.out.println("Job  "+this.name+ "Completed");
}

 }