public static void main(String[] args) {


    Clock clock = new Clock();
    Thread th = new Thread(clock);
    th.start();

    Scanner input = new Scanner(System.in);
    int a = input.nextInt();

    if(a==1)
        clock.stop();    
}