public static void main(String[] argv) throws InterruptedException // Thread.sleep throws that
{
    Random rng = new Random();
    Date start = new Date();
    Thread.sleep(rng.nextInt(1000)); // sleep for 0-999 ms
    Date end = new Date();
    System.out.println("Slept for " + (end.getTime() - start.getTime()) + "ms.");
}