public class Avenger
{
    public Avenger()
    {
        JavaClassScriptCache.doNotCollect(this);
    }

    public static void main(String[] args)
    {
        // this method is called after compiling
        new Avenger();
    }
}