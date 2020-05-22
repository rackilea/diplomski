public class LogFile {

     public String process(Map<String,String> eventLog) {
        // do stuff
        return success;
     }

     public void main(String[] args) {
         // eventLog will probably be read from a filepath passed into the args
        String result = new LogFile().process(eventLog);
        System.out.println("result = " + result);
     }
}