import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class ConsolePlugin extends JavaPlugin {

    public Logger log;

    public void onEnable(){
        log = this.getLogger();
        log.info("BufferedReader has been enabled!");
        new Thread(new Runnable(){
            public void run(){
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                String line = null;
                while (true){
                    try {
                        line=br.readLine();
                    } catch (Exception e) {e.printStackTrace();}
                    if (line!=null){
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), line);
                        System.out.println(line);
                    }
                }
            }
        }).start();
    }

    public void onDisable(){
        log.info("BufferedReader has been disabled.");
    }
}