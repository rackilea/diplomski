public class Command {
    private static OutputStream os;
    private static OutputStreamWriter osw;
    private static Process process;
    public static void start(){
        try { 
            ProcessBuilder pb = new ProcessBuilder( "/usr/bin/tee", "x.dat" );
            process = pb.start();
            os = process.getOutputStream();
            osw = new OutputStreamWriter( os );
        } catch( Exception e ){
            // error handling
        } catch( Error e ){
            // error handling
        }
    }

    public static void terminate() throws Exception {
        process.waitFor();
    }

    public static void command( String str ) throws Exception {
        String cmd = str + System.lineSeparator();
        osw.write( cmd, 0, cmd.length() );
        osw.flush();
    }