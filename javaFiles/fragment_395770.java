public class MAIN extends JavaPlugin{
public MAIN() {
    try {
        this.fw = new FileWriter("plugins/TestMessage/messages.txt", true);
    } catch (Exception e) {
        // TODO: handle exception
    }

}

FileWriter fw = null;

public void onEnable(){
    Logger.getLogger("Minecraft").info("MessageBroadcaster made by cheeseballs500 aka weakwizardsucks2");
}

public void onDisable(){
    try {
        fw.close();
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }//fw cannot be resolved
}
}