public class Whatever extends JavaPlugin {

    @Override
    public void onEnable(){
        this.getCommand("test").setExecutor(new MyCommandExecutor(this));
        // register the class MyCommandExecutor as the executor for the "test" command
    }

    @Override 
    public void onDisable(){

    }

}