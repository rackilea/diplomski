public class Fetcher implements Runnable{
    public void run(){
      //do fetching stuff
    }
}

//in your code
Thread fetchThread = new Thread(new Fetcher());
fetchThread.start();