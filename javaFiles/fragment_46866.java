public class Mathgame {

    // it is not necessary do it static
    public int secondsPassed = 0;

    //alternatively you can use  Timer timer = new Timer(true); if you want to stop timer immediately after method main is finished
    Timer timer = new Timer();
    TimerTask task = new TimerTask() {

        public void run() {

            secondsPassed++;
            // your timer will run this method every 1 sec, so you need to put output here if you want to see changes
            System.out.println("Running my task again. secondsPassed is " +secondsPassed);
        }

    };

    public void start() {
        //this timmer will run your task every 1000ms (1 second) and will start in 1000ms (1 second) after start is called
        timer.scheduleAtFixedRate(task, 1000, 1000);
    }

    // this is main method so it is better to throw exceptions upper then handler them without output
    public static void main(String[] args) throws InterruptedException {


        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to 'The Math Game!' Please chose whether you would like to play or not by inputting 'yes' or 'no'.");

        String x = input.nextLine();

        // it is better to check for 'yes' than for 'no' this is good practice
        if (x.equalsIgnoreCase("yes") || x.equalsIgnoreCase("y")) {

            System.out.println("OK! We are starting the game in...");

            System.out.println("3");

            Thread.sleep(1000);

            System.out.println("2");

            Thread.sleep(1000);

            System.out.println("1!!");

            Thread.sleep(1000);

            System.out.println("Go!");

            //starting your timer, we have to create object of your class first and then run method start
            Mathgame mathgame = new Mathgame();
            mathgame.start();

            System.out.println("Your timer started!");

            //main is finished however there is timer thread which is still working
            // if you want to stop timer immediately after main then you need to build it as 'Timer timer = new Timer(true);'
            // in that case you may put here extra sleep and see how timer is working

            //let wait until timer will count 10 sec
            Thread.sleep(10000);
            //you can check secondsPassed from main too
             System.out.println("This is called from main. secondsPassed value is " + mathgame.secondsPassed);

            System.out.println("Method main is finished");
        }
    }
}