class UtilityDelegate {
    UtilitytDelegate(){ .... }

    void performWork(File f) throws IOException {
        // do something with file
    }
}

public class SomeUtility {
    public static void main(final String[] args) throws IOException {
        File f = null;
        try{
            // do something that could throw an exception
            f = new File(args[0]);
            performWork(f);
        } finally {
            // do necessary clean-up, if any, such as closing file handles,
            // sockets, flushing database changes, pray to Lord Xenu, whatever

            if( f != null ){
                try{
                    f.close();
                }catch (IOException e){
                    e.printStackTrace(); // or use a logging mechanism or whatever
                }
            }
        }
    }
}