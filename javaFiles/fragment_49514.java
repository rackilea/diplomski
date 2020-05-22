public class App 
{
    public static void main( String[] args )
    {
        TreeMap<App,String> tm = new TreeMap<App,String>();
        tm.put(new App(), "value");
    }
}