import java.util.Date;               //importing this package just to use Date()

public class StackOverflowQ {

 public interface CallBackInt{
    String doJob(String str);
    }

public static void main(String[] args) {

    CallBackInt variable = new CallBackInt(){       //using the interface
        public String doJob(String str) {       //doJob method from interface
            return (str + new Date().toString()); 
                  //used .toString() as return type of doJob is String
        }
    };


    while (true) {                            //infinite loop

        System.out.println(variable.doJob("Current Date Instance is: "));
        try {
            Thread.sleep(60*1000);            
            //time is in miliseconds and 60*1000 mili sec=60 seconds = 1 minute
        }
        catch (InterruptedException e) {   
         //if there are any Exception thrown, this will catch it and help you !

            e.printStackTrace();
        }
    }

}
}