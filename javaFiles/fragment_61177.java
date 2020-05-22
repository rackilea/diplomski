public class SomeUtilityClient{
    public static void main(final String[] args){
        // for brevity, I'm omitting the case when the utility might
        // call System.exit() itself.
        try{
            SomeUtility.main("a-pre-defined-filename");
        } catch(IOException e){
            someLog("call to utility failed, see exception", e);
            System.exit(-1);
        }
        System.exit(0);
    }
}