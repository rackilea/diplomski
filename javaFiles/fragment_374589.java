public class FileUtils{
    private static File appHome = null;
    static{
        String home = System.getProperty("app.home");//-D that you specify or some standard that java has see javadoc
        if(home == null){
            //logger as needed
            home = "/app1";

        }
        appHome = new File(home);
    }


    public static File getAppHome(){
        return appHome;
        }


    ...