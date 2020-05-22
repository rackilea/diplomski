public class Logger
{
    private static final Object GAME_LOG_LOCK = new Object();
    private static final Object SERVER_LOG_LOCK = new Object();

    public static void printToGameLog(String value){
        synchronized (GAME_LOG_LOCK) {
            Writer writer = null;
            try {
                writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream("GameLog.txt", true), "utf-8"));
                writer.write(outputString + "\r\n");
            } catch (IOException ex){
                System.out.println("cannot create log file");
            } 
        }
    }

    public static void printToServerLog(String value){
        synchronized (SERVER_LOG_LOCK) {   
            Writer writer = null;
            try {
                writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream("serverLog.txt", true), "utf-8"));
                writer.write(outputString + "\r\n");
            } catch (IOException ex){
                  System.out.println("cannot create log file");
            }
        }
    }
}