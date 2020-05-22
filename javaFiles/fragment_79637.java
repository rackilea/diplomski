public class PandaCare {

    //...

    public void hungerWait() {
        int Low = 5;
        int High = 30;
        HWT = r.nextInt(High - Low) + Low;

        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        hunger--;
    }

    // This won't work, it's not a valid statement...
    while(hunger > 0){
       hungerWait();
    }

}