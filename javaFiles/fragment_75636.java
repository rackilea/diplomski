@Service
public class Fetcher implements Runnable{
    public void run(){
      //do stuff
    }

    @PostConstruct
    public void goDoIt(){
      Thread trd = new Thread(this);
      trd.start();
    }
}