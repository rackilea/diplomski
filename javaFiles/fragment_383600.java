public class Sender{

ConsoleWriter cWriter = new ConsoleWriter();
public void execute(){
    this.ui = ui;
    try{
        ProcessBuilder pb = new ProcessBuilder(path_to_server+"launch.bat");
        Process process = pb.start();

        StreamGobbler sgError = new StreamGobbler(process.getErrorStream());

        new Thread( sgError ).start();
        writer = new PrintWriter( process.getOutputStream() );

    } catch ( IOException e ){
        e.printStackTrace();
    }
}

private class StreamGobbler implements Runnable 
{
    private InputStream is;
    public StreamGobbler( InputStream is ){
        this.is = is;
    }
    @Override
    public void run() {
        try {
            InputStreamReader isr = new InputStreamReader( is );
            BufferedReader br = new BufferedReader( isr );
            String line = null;
            while ( ( line = br.readLine() ) != null ){
                cWriter.writer(line, ui);
            }
        } catch ( IOException e ){
            e.printStackTrace();
        }
    }
}

}