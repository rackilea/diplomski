public class InputStreamLineBuffer{
    private boolean emergencyBrake = false;
    [...]
    public InputStreamLineBuffer(InputStream is){
        [...]
                while ((b = inputStream.read()) != -1 && !emergencyBrake){
                    [...]
                }
    }
    [...]

    // exits immediately and clears line buffer
    public void destroy(){
        emergencyBrake = true;
        lines.clear();
    }
}