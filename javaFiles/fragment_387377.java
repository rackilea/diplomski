import java.util.concurrent.*;
import java.io.*;    

public class Test {
    public static void main(String[] args) throws java.io.IOException {
        Question q = new Question();
        System.out.println("You have 5 seconds: " + q.toString());

        String userAnswer = null;    
        ExecutorService ex = Executors.newSingleThreadExecutor();
        try {
          Future<String> result = ex.submit(new GetInputLineCallable());
          try {
            userAnswer = result.get(5, TimeUnit.SECONDS);
            if (Integer.valueOf(userAnswer) == q.getAnswer()){
                System.out.println("good!");
            }
            else{
                System.out.println("Incorrect!");
            }

          } catch (ExecutionException e) {
            e.getCause().printStackTrace();
          } catch (TimeoutException e){
            System.out.println("too late!");
            return;
          } catch (InterruptedException e){
            System.out.println("interrupted?");
            e.getCause().printStackTrace();
          }

        } finally {
          ex.shutdownNow();
        }
    }
}



class GetInputLineCallable implements Callable<String> {
  public String call() throws IOException {
    BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
    String input = "";
    while ("".equals(input)) {
      try {
        while (!inp.ready()) {
          Thread.sleep(100);
        }
        input = inp.readLine();
      } catch (InterruptedException e) {
        return null;
      }
    } 
    return input;
  }
}




class Question{
  int p1, p2;
  public Question(){
    p1 = 2;
    p2 = 3;
  }
  public String toString(){
    return String.format("%d + %d = ?", p1, p2);
  }
  public int getAnswer(){
    return p1+p2;
  }  
}